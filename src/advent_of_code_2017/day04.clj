(ns advent-of-code-2017.day04
  (:require [clojure.string :as s]))

(def input
  (map #(s/split % #" ") (s/split (slurp "./data/day04.txt") #"\n")))

(defn is-valid? [passphrase]
  (= (count passphrase) (count (set passphrase))))

(defn part-1 [data]
  (count (filter is-valid? data)))

(defn part-2 [data]
  (->> data
       (map (fn [phrase] (map #(apply str (sort %)) phrase)))
       part-1))
