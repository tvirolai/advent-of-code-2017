(ns advent-of-code-2017.day06
  (:require [clojure.string :as s]))

"""
The horror, the inefficiency.
"""

(defn load-input []
  (mapv #(Integer. %)
        (-> (slurp "./data/day06.txt") s/trim-newline (s/split #"\t"))))

(defn reallocate [banks]
  (loop [maxval (apply max banks)
        index (.indexOf banks maxval)
        newbanks (assoc banks index 0)]
    (if (zero? maxval)
      newbanks
      (let [nextindex (if (= index (dec (count banks)))
                             0
                             (inc index))]
        (recur (dec maxval)
               nextindex
               (update-in newbanks [nextindex] inc))))))

(defn part-1 [data]
  (loop [round 1
         seen (set '())
         current (reallocate data)]
    (if (contains? seen current)
      round
      (recur (inc round)
             (conj seen current)
             (reallocate current)))))

(defn part-2 [data]
  (loop [round 1
         seen []
         current (reallocate data)]
    (if (> (.indexOf seen current) -1)
      (- (dec round) (.indexOf seen current))
      (recur (inc round)
             (conj seen current)
             (reallocate current)))))
