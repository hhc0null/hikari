(ns hikari.time_utils
  (:require [clj-time.core :as timec]
            [clj-time.local :as timel]
            [clj-time.format :as timef]))

(def date-formatter
  (timef/formatter-local "YYYY-MMdd_hhmmss"))

(defn now-time
  []
  (timef/unparse date-formatter (timel/local-now)))

