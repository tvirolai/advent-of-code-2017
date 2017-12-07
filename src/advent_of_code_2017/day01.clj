(ns advent-of-code-2017.day01
  (:require [clojure.string :as s]))

(defn load-input []
  (-> (slurp "./data/day01.txt") s/trim-newline))

(defn part-1 [input]
  (->> (take (inc (count input)) (cycle input))
       (partition-by identity)
       (filter #(> (count %) 1))
       (mapcat drop-last)
       (map #(Character/digit % 10))
       (reduce +)))

(defn part-2 [input]
  (->> input
       (partition (/ (count input) 2))
       (#(interleave (first %) (last %)))
       (partition 2)
       (filter #(= (first %) (last %)))
       flatten
       (map #(Character/digit % 10))
       (reduce +)))
