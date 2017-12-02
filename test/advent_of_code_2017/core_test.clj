(ns advent-of-code-2017.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.core :refer :all]
            [advent-of-code-2017.day01 :as day01]
            [advent-of-code-2017.day02 :as day02]))

(deftest examples
  (testing "Day 1, part 1"
    (is (= (day01/part-1 "1122") 3))
    (is (= (day01/part-1 "1111") 4))
    (is (= (day01/part-1 "1234") 0))
    (is (= (day01/part-1 "91212129") 9)))
  (testing "Day 1, part 2"
    (is (= (day01/part-2 "1212") 6))
    (is (= (day01/part-2 "1221") 0))
    (is (= (day01/part-2 "123425") 4))
    (is (= (day01/part-2 "123123") 12))
    (is (= (day01/part-2 "12131415") 4))))

(deftest day2
  (testing "Day 2, part 1"
    (is (= (day02/part-1 "5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8") 18))))
