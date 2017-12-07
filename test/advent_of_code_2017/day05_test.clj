(ns advent-of-code-2017.day05-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day05 :as d5]))

(def example-input
  [0 3 0 1 -3])

(deftest day05
  (testing "Helper functions"
    (vector? (d5/load-input)))
  (testing "Day 5, part 1 with the example input"
    (is (= 5 (d5/solve example-input 1))))
  (testing "Day 5, part 1 with the puzzle input"
    (is (= 376976 (d5/solve (d5/load-input) 1))))
  (testing "Day 5, part 2 with the example input"
    (is (= 10 (d5/solve example-input 2)))))
