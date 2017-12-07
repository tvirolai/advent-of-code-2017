(ns advent-of-code-2017.day06-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day06 :as d6]))

(def example-input
  [0 2 7 0])

(deftest day06
  (testing "Day 6, part 1 with the example input"
    (is (= 5 (d6/solve example-input 1))))
  (testing "Day 6, part 2 with the example input"
    (is (= 4 (d6/solve example-input 2)))))
