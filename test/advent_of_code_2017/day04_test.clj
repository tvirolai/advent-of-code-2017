(ns advent-of-code-2017.day04-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day04 :as d4]))

(deftest day04
  (testing "Day 4, part 1 with example inputs"
    (is (= 2 (d4/part-1 [["aa" "bb" "cc" "dd" "ee"]
                         ["aa" "bb" "cc" "dd" "aa"]
                         ["aa" "bb" "cc" "dd" "aaa"]]))))
  (testing "Day 4, part 1 with the puzzle input"
    (is (= 337 (d4/part-1 (d4/load-input)))))
  (testing "Day 4, part 2 with example inputs"
    (is (= 3 (d4/part-2 [["abcde" "fghij"]
                         ["abcde" "xyz" "ecdab"]
                         ["a" "ab" "abc" "abd" "abf" "abj"]
                         ["iiii" "oiii" "ooii" "oooi" "oooo"]
                         ["oiii" "ioii" "iioi" "iiio"]]))))
  (testing "Day 4, part 2 with the puzzle input"
    (is (= 231 (d4/part-2 (d4/load-input))))))
