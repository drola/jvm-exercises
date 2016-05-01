(ns si.drola.jvmExercises.sorting
  (:require [clojure.core.match :refer [match]])
  (:import (si.drola.jvmExercises.sorting ISorter)))


(defn insert [sorted x]
  (let [[smaller-than-x bigger-than-x] (split-with (partial > x) sorted)]
    (concat smaller-than-x (cons x bigger-than-x))))

(defn insertion-sort [numbers] (reduce insert '() numbers))

(defrecord
  CljInsertionSort []
  :load-ns true
  ISorter
  (sort [this numbers] (int-array (insertion-sort numbers))))
