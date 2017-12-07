(ns advent-of-code-2017.day02-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day02 :as d2]))

(deftest day02
  (testing "Day 2, part 1 with example inputs"
    (is (= 18 (d2/part-1 "5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8"))))
  (testing "Day 2, part 1 with provided input"
    (is (= 34925 (d2/part-1 (d2/load-input)))))
  (testing "Day 2, part 2 with example inputs"
    (is (= 9 (d2/part-2 "5\t9\t2\t8\n9\t4\t7\t3\n3\t8\t6\t5"))))
  (testing "Day 2, part 2 with provided input"
    (is (= 221 (d2/part-2 (d2/load-input))))))
