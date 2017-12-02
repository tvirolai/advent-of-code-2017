(ns advent-of-code-2017.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day01 :refer :all]))

(deftest examples
  (testing "1122"
    (is (= (part-1 "1122") 3))))
