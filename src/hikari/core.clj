(ns hikari.core
  (:use [hikari.opencv_utils]
        [hikari.time_utils]))

(defn set-wait-period 
  [& n]
  (println "wait period [s] ([1-9])")
  (print "> ")
  (flush)
  (if-not (nil? n) 
    n
    (let [n (read-line) pattern #"^[1-9]"]
      (if-let [n (re-find pattern n)]
        (read-string n)
        1))))

(defn -main
  "An image capture from webcam writen in Clojure."
  [& args]
  (let [n (set-wait-period)]
    (println (str "Wait for " n " seconds"))
    (if-not (nil? args)
      (take-a-photo (first args) n)
      (take-a-photo (now-time) n))))
