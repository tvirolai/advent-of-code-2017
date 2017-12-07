(ns advent-of-code-2017.day03)

(defn corners [value]
  "Returns an lazy sequence of down-left corner values. The last one
  belongs to the same circle as the value given."
  (let [points (->> (range)
                    (filter odd?)
                    (map (fn [x] (let [value (+ 2 x)] (* value value)))))
        largest (->> points (drop-while (partial > value)) first)]
    (take-while (partial >= largest) points)))

(defn cornercoords [value]
  "Takes a value and return a map containing information about the point in
  down-left corner."
  (let [se (corners value)
        cornerval (last se)
        sidelength (int (Math/sqrt cornerval))
        bottomright {:value cornerval :x (count se) :y (- (count se))}
        bottomleft {:value (- cornerval (dec sidelength)) :x (- (count se)) :y (- (count se))}
        topleft {:value (- cornerval (* 2 (dec sidelength))) :x (- (:x bottomright)) :y (- (:y bottomright))}
        topright {:value (- cornerval (* 3 (dec sidelength))) :x (:x bottomright) :y (:y topleft)}]
    {:br bottomright
     :bl bottomleft
     :tl topleft
     :tr topright}))

(defn coords-for-point
  "What a monstrosity."
  [point]
  (let [coords (cornercoords point)]
    (cond
      (<= (:value (:bl coords)) point (:value (:br coords)))
      {:x (+ (:x (:br coords)) (- point (:value (:br coords)))),
       :y (:y (:br coords))} ; The given point is between bottom-left and bottom-right corners
      (<= (:value (:tl coords)) point (:value (:bl coords)))
      {:x (:x (:tl coords)),
       :y (- (:y (:tl coords)) (- point (:value (:tl coords))))} ; Point is between top-left and bottom-left corners
      (<= (:value (:tr coords)) point (:value (:tl coords)))
      (let [difference (- (get-in coords [:tl :value]) point)]
        {:x (+ (get-in coords [:tl :x]) difference)
         :y (get-in coords [:tl :y])}) ; Point is between top-left and top-right corners
      (< point (get-in coords [:tr :value]))
      (let [difference (- (get-in coords [:tr :value]) point)]
        {:x (get-in coords [:tr :x])
         :y (- (get-in coords [:tr :y]) difference)}))))


(defn part-1 [value]
  (let [coords (coords-for-point value)]
    (if (> 2 value)
      0
      (+ (Math/abs (:x coords)) (Math/abs (:y coords))))))
