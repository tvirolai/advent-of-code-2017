(ns advent-of-code-2017.day07
  (:require [clojure.string :as s]
            [clojure.set :as cset]))

(def example-input
  "pbga (66)
xhth (57)
ebii (61)
havc (66)
ktlj (57)
fwft (72) -> ktlj, cntj, xhth
qoyq (66)
padx (45) -> pbga, havc, qoyq
tknk (41) -> ugml, padx, fwft
jptl (61)
ugml (68) -> gyxo, ebii, jptl
gyxo (61)
cntj (57)")

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
