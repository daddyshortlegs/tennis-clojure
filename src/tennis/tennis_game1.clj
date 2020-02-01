(ns tennis.tennis-game1
  (:require [tennis.tennis-game :refer :all]))

(def m_score_1 (atom 0))
(def m_score_2 (atom 0))

(defrecord TennisGame1 [player1Name player2Name]
  TennisGame
  (won-point [_ player_name]
    (cond
      (= player_name "player1") (reset! m_score_1 (inc @m_score_1))
      :else (reset! m_score_2 (inc @m_score_2))
      )
    )

  (get-score [_]
    (let [score ""]
      (cond
        (= @m_score_1 @m_score_2)
        (cond
          (= @m_score_1 0) "Love-All"
          (= @m_score_1 1) "Fifteen-All"
          (= @m_score_1 2) "Thirty-All"
          :else "Deuce")

        (or (>= @m_score_1 4) (>= @m_score_2 4))
        (let [minus_result (- @m_score_1 @m_score_2)]
          (cond (= minus_result 1) "Advantage player1"
                (= minus_result -1) "Advantage player2"
                (>= minus_result 2) "Win for player1"
                :else "Win for player2"))
        :else
        (apply str
               (for [i (range 1 3)]
                 (let [temp-score (if (= i 1) @m_score_1 @m_score_2)
                       the-score (if (not (= i 1)) (str score "-") "")]
                   (case temp-score
                     0 (str the-score "Love")
                     1 (str the-score "Fifteen")
                     2 (str the-score "Thirty")
                     3 (str the-score "Forty")
                     )
                   )
                 )
               )
        )
      )
    )
  )