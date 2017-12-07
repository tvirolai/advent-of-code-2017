(ns advent-of-code-2017.day03-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day03 :as d3]))

(deftest day03
  (testing "Testing helper functions"
    (is (= 25 (last (d3/corners 24))))
    (is (= {:x -2 :y -2} (d3/coords-for-point 21)))
    (is (= 4 (count (d3/cornercoords 19))))
    (is (map? (d3/cornercoords 21)))
    (is (every? (partial = 9) (take 100 (map first (map d3/corners (range)))))))
  (testing "Day 3, part 1 with example inputs"
    (is (= 0 (d3/part-1 1)))
    (is (= 3 (d3/part-1 12)))
    (is (= 2 (d3/part-1 23)))
    (is (= 31 (d3/part-1 1024)))))
