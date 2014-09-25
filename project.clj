(defproject hikari "0.1.0-SNAPSHOT"
  :description "\"hikari\" is an image capture from webcam."
  :url "https://github.com/hhc0null/hikari"
  :license {:name "MIT License"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [me.raynes/fs "1.4.4"]
                 [clj-time "0.8.0"]
                 [clojure-lanterna "0.9.4"]
                 [opencv "2.4.10"]
                 [opencv/opencv-native "2.4.10"]
                 [seesaw "1.4.4"]]
  :injections [(clojure.lang.RT/loadLibrary org.opencv.core.Core/NATIVE_LIBRARY_NAME)]
  :main hikari.core)
