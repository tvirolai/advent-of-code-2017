(ns advent-of-code-2017.day07-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day07 :as d7]))

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

(deftest day07
  (testing "Day 7, part 1 with example input"
    (is (= "tknk" (d7/part-1 example-input))))
  (testing "Load-input -function"
    (is (string? (d7/load-input)))
    (is (map? (d7/parse-data example-input)))))
