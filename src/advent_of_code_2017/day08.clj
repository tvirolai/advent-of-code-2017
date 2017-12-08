(ns advent-of-code-2017.day08
  (:require [clojure.string :as s]))

(defn load-input []
  (-> "./data/day08.txt" slurp (s/split #"\n")))

(defn parse-line [line]
  (let [[register instr amount] (s/split line #" ")]
    {:register register
     :instr instr
     :amount (Integer. amount)
     :condition (last (s/split line #" if "))}))

(defn parse-cond
  "Takes an instruction like 'a > 1', returns a function that takes a state map"
  [condition]
  (let [[register operator amount] (s/split condition #" ")]
    (fn [state]
      (let [op (case operator
                 "==" =
                 "!=" not=
                 ">" >
                 "<" <
                 ">=" >=
                 "<=" <=)]
        (op ((keyword register) state) (Integer. amount))))))

(defn initialize-state [data]
  (let [parsed (map parse-line data)
        registers (map (comp keyword :register) parsed)]
    (zipmap registers (take (count registers) (repeat 0)))))


(defn update-state [state instruction]
  (let [testf (parse-cond (:condition instruction))]
    (if (testf state)
      (update state
              (keyword (:register instruction))
              (if (= "inc" (:instr instruction))
                +
                -)
              (:amount instruction))
      state)))

(defn solve [data part]
  (loop [state (initialize-state data)
         instrs (map parse-line data)
         highest 0]
    (let [high (apply max (vals state))]
      (if (empty? instrs)
        (if (= part 1)
          high
          highest)
        (recur (update-state state (first instrs))
               (rest instrs)
               (if (> high highest) high highest))))))
