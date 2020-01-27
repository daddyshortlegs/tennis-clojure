(ns tennis.tennis-game2
  (:gen-class))

(def P1point (atom 0))

(def P2point (atom 0))


(defn get-score [P1point P2point]
  (let [score (atom "")]
    (cond
      (and (= P1point P2point) (< P1point 4))
      (cond
        (= P1point 0) (reset! score "Love")
        (= P1point 1) (reset! score "Fifteen")
        (= P1point 2) (reset! score "Thirty")
        :else (reset! score "-All"))

      (and (= P1point P2point) (>= P1point 3))
      (reset! score "Deuce")

      (and (> P1point 0) (= P2point 0))
      (cond
        (= P1point 1) (reset! P1res "Fifteen")
        (= P1point 2) (reset! P1res "Thirty")
        (= P1point 3) (reset! P1res "Forty")
        :else (reset! P2res "Love")
        )
      )
    )

  )
