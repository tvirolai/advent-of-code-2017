(ns advent-of-code-2017.day08-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day08 :as d8]))

(def example-input
  ["b inc 5 if a > 1"
   "a inc 1 if b < 5"
   "c dec -10 if a >= 1"
   "c inc -20 if c == 10"])

(deftest day08
  (let [puzzleinput (d8/load-input)]
    (testing "Day 8, helper functions"
      (is (vector? puzzleinput)))
    (testing "Day 8, part 1 with example input"
      (= 1 (d8/solve example-input 1)))
    (testing "Day 8, part 1 with the puzzle input"
      (= 7787 (d8/solve puzzleinput 1)))
    (testing "Day 8, part 2 with example input"
      (= 10 (d8/solve example-input 10)))
    (testing "Day 8, part 2 with the puzzle input"
      (= 8997 (d8/solve puzzleinput 2)))))
