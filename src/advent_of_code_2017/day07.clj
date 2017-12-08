(ns advent-of-code-2017.day07
  (:require [clojure.string :as s]
            [clojure.set :as cset]))

(defn load-input []
  (slurp "./data/day07.txt"))

(defn parse-data [string]
  (let [rows (s/split string #"\n")
        entries (map #(first (s/split % #" ")) rows)
        branches (->> rows
                      (filter #(.contains % " -> "))
                      (map #(last (s/split % #" -> ")))
                      (map #(s/split % #", "))
                      flatten)]
    {:entries entries
     :branches branches}))

(defn part-1 [data]
  (let [{entries :entries branches :branches} (parse-data data)]
    (first (cset/difference (set entries) (set branches)))))
