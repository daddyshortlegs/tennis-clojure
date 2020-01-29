(ns tennis.tennis-test
  (:require [clojure.test :refer :all]
            [tennis.tennis-game :refer :all]
            [tennis.tennis-game3 :refer :all]
            )
  (:import (tennis.tennis_game3 TennisGame3)))

(def tennis-game3 (TennisGame3. "" ""))



(defn check-all-scores2 [p1-score p2-score]
  (do
    (reset! p1 0)
    (reset! p2 0)
    (repeatedly p1-score #(won-point tennis-game3 "player1"))
    (repeatedly p2-score #(won-point tennis-game3 "player2"))
    (get-score tennis-game3))
  )

(defn check-all-scores [p1-score p2-score]
  (do
    (reset! p1 p1-score)
    (reset! p2 p2-score)
    (get-score tennis-game3))
  )

(deftest check-all-scores-tennis-game-1
  (is (= "Love-All" (check-all-scores 0 0)))
  (is (= "Fifteen-All" (check-all-scores 1 1)))
  (is (= "Thirty-All" (check-all-scores 2 2)))
  (is (= "Deuce" (check-all-scores 3 3)))
  (is (= "Deuce" (check-all-scores 4 4)))

  (is (= "Fifteen-Love" (check-all-scores 1 0)))
  (is (= "Love-Fifteen" (check-all-scores 0 1)))
  (is (= "Thirty-Love" (check-all-scores 2 0)))
  (is (= "Love-Thirty" (check-all-scores 0 2)))
  (is (= "Forty-Love" (check-all-scores 3 0)))
  (is (= "Love-Forty" (check-all-scores 0 3)))
  (is (= "Win for player1" (check-all-scores 4 0)))
  (is (= "Win for player2" (check-all-scores 0 4)))

  (is (= "Thirty-Fifteen" (check-all-scores 2 1)))
  (is (= "Fifteen-Thirty" (check-all-scores 1 2)))
  (is (= "Forty-Fifteen" (check-all-scores 3 1)))
  (is (= "Fifteen-Forty" (check-all-scores 1 3)))
  (is (= "Win for player1" (check-all-scores 4 1)))
  (is (= "Win for player2" (check-all-scores 1 4)))

  (is (= "Forty-Thirty" (check-all-scores 3 2)))
  (is (= "Thirty-Forty" (check-all-scores 2 3)))
  (is (= "Win for player1" (check-all-scores 4 2)))
  (is (= "Win for player2" (check-all-scores 2 4)))

  (is (= "Advantage player1" (check-all-scores 4 3)))
  (is (= "Advantage player2" (check-all-scores 3 4)))
  (is (= "Advantage player1" (check-all-scores 5 4)))
  (is (= "Advantage player2" (check-all-scores 4 5)))
  (is (= "Advantage player1" (check-all-scores 15 14)))
  (is (= "Advantage player2" (check-all-scores 14 15)))

  (is (= "Win for player1" (check-all-scores 6 4)))
  (is (= "Win for player2" (check-all-scores 4 6)))
  (is (= "Win for player1" (check-all-scores 16 14)))
  (is (= "Win for player2" (check-all-scores 14 16)))
  )
