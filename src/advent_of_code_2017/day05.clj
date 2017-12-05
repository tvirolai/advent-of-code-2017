(ns advent-of-code-2017.day05)

(defn load-input []
  (mapv #(Integer. %) (clojure.string/split (slurp "./data/day05.txt") #"\n")))

(defn solve [input part]
  "Input: result of load-input
   Part: 1 or 2"
  (loop [index 0
         data input
         steps 0]
    (if-not (<= 0 index (dec (count data)))
      steps
      (recur (+ index (data index))
             (update-in data [index] (if (and
                                           (= part 2)
                                           (>= (data index) 3))
                                       dec
                                       inc))
             (inc steps)))))
