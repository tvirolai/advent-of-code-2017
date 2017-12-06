(ns advent-of-code-2017.day02
  (:require [clojure.string :as s]))

(def input
  (slurp "./data/day02.txt"))

(defn parse-from-string [string]
  (->> (s/split input #"\n")
       (map #(s/split % #"\t"))
       (map (fn [line] (reverse (sort (map #(Integer. %) line)))))))

(defn part-1 [input]
  (->> (parse-from-string input)
       (transduce (map #(- (first %) (last %))) +)))

(defn solve-line [line]
  (let [res (for [x (rest line)
                  :when (zero? (rem (first line) x))]
              (/ (first line) x))]
    (if (empty? res)
      (solve-line (rest line))
      (first res))))

(defn part-2 [input]
  (->> (parse-from-string input)
       (transduce (map solve-line) +)))
