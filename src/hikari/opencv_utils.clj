(ns hikari.opencv_utils
  (:require [clojure.string :as str-utils])
  (:import [org.opencv.highgui Highgui]
           [org.opencv.highgui VideoCapture]
           [org.opencv.core MatOfByte]
           [org.opencv.core Mat]))

(def matrix (atom (Mat.)))

(defn delay-and-dislpay
  [n]
  (loop [i n]
    (if (> i 0)
      (do (print (str i "..."))
          (flush)
          (Thread/sleep (* i 1000))
          (recur (dec i)))
      (println "\nSnap!"))))

(defn capture-from-webcam
  []
  (let [vc (VideoCapture. 0) m (Mat.)] 
    (.read vc m)
    (.release vc)
    (reset! matrix m)))

(defn write-to-file
  [filename]
  (Highgui/imwrite (str "resources/" filename ".png") @matrix))

(defn take-a-photo
  [filename wait-time]
  (println "take a first shot!!")
  (delay-and-dislpay wait-time)
  (capture-from-webcam)
  (println "One more shot? press y/N")
  (do (print "> ") (flush))
  (loop [confirm (read-line)]
    (cond 
      (or (empty? confirm)
          (zero? (compare (str-utils/lower-case confirm) "n"))
          (zero? (compare (str-utils/lower-case confirm) "no")))
        (do (write-to-file filename)
            (println "Captured!"))
      (or (zero? (compare (str-utils/lower-case confirm) "y"))
          (zero? (compare (str-utils/lower-case confirm) "yes")))
        (do (delay-and-dislpay wait-time)
            (capture-from-webcam)
            (println "One more shot? press y/N")
            (do (print "> ") (flush))
            (recur (read-line)))
      :else
        (do (println "Press [Y]/n")
            (recur (read-line))))))
