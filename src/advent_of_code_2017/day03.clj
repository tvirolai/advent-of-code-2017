(ns advent-of-code-2017.day03)

(defn get-dims [n]
  "Takes a number and returns the dimensions of the square where it's contained."
  (loop [dim 3
         coords {:x 1 :y 1}]
    (if (>= (* dim dim) n)
      {:dims dim
       :cornerval (* dim dim)
       :coords coords}
      (recur (+ dim 2)
             {:x (inc (:x coords))
              :y (inc (:y coords))}))))
