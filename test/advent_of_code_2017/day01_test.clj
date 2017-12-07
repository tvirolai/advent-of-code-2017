(ns advent-of-code-2017.day01-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day01 :as d1]))

(deftest day01
  (testing "Day 1, part 1 with example inputs"
    (is (= 3 (d1/part-1 "1122")))
    (is (= 4 (d1/part-1 "1111")))
    (is (= 0 (d1/part-1 "1234")))
    (is (= 9 (d1/part-1 "91212129"))))
  (testing "Day 1, part 1 with provided input"
    (is (= 1390 (d1/part-1 (d1/load-input)))))
  (testing "Day 1, part 2 with example inputs"
    (is (= 6 (d1/part-2 "1212")))
    (is (= 0 (d1/part-2 "1221")))
    (is (= 4 (d1/part-2 "123425")))
    (is (= 12 (d1/part-2 "123123")))
    (is (= 4 (d1/part-2 "12131415"))))
  (testing "Day 1, part 2 with provided input"
    (is (= 1232 (d1/part-2 (d1/load-input))))))
