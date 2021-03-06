(ns tennis.tennis-game3
  (:require [tennis.tennis-game :refer :all]))

(def p1 (atom 0))
(def p2 (atom 0))

(defrecord TennisGame3 [p1N p2N]
  TennisGame
  (get-score [_]
    (if (and (< @p1 4) (< @p2 4) (not (= (+ @p1 @p2) 6)))
      (let [p ["Love" "Fifteen" "Thirty" "Forty"]
            s (nth p @p1)]
        (if (= @p1 @p2)
          (str s "-All")
          (str s "-" (nth p @p2))))
      (if (= @p1 @p2)
        "Deuce"
        (let [s (if (> @p1 @p2) "player1" "player2")]
          (if (= (* (- @p1 @p2) (- @p1 @p2)) 1)
            (str "Advantage " s)
            (str "Win for " s))))))

  (won-point [_ player_name]
    (cond
      (= player_name "player1") (swap! p1 (inc @p1))
      :else (swap! p2 (inc @p2))
      )
    )
  )
