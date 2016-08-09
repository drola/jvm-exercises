(ns si.drola.jvmExercises.search
  (:require [clojure.core.match :refer [match]])
  (:import (si.drola.jvmExercises.search ISearch)))


(defn linear-search [needle haystack i] (cond
                                          (empty? haystack) -1
                                          (== (first haystack) needle) i
                                          :else (recur needle (rest haystack) (inc i))))

(defrecord
  CljLinearSearch []
  :load-ns true
  ISearch
  (find [this needle haystack] (linear-search needle haystack 0)))
