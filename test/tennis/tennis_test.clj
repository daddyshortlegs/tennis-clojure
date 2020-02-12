(ns tennis.tennis-test
  (:require [clojure.test :refer :all]
            [tennis.tennis-game :refer :all]
            [tennis.tennis-game1 :refer :all]
            [tennis.tennis-game2 :refer :all]
            [tennis.tennis-game3 :refer :all]
            )
  (:import (tennis.tennis_game3 TennisGame3)
           (tennis.tennis_game2 TennisGame2)
           (tennis.tennis_game1 TennisGame1)))

(def tennis-game1 (TennisGame1. "" ""))
(def tennis-game2 (TennisGame2. "" ""))
(def tennis-game3 (TennisGame3. "" ""))


(defn check-all-scores [p1-score p2-score]
  (do
    (reset! P1point p1-score)
    (reset! P2point p2-score)
    (get-score tennis-game2))
  )

(deftest check-all-scores-tennis-game-1
  (are [result score1 score2] (= result (check-all-scores score1 score2))
                              "Love-All" 0 0,
                              "Fifteen-All" 1 1,
                              "Thirty-All" 2 2,
                              "Deuce" 3 3,
                              "Deuce" 4 4

                              "Fifteen-Love" 1 0
                              "Love-Fifteen" 0 1
                              "Thirty-Love" 2 0
                              "Love-Thirty" 0 2
                              "Forty-Love" 3 0
                              "Love-Forty" 0 3
                              "Win for player1" 4 0
                              "Win for player2" 0 4

                              "Thirty-Fifteen" 2 1
                              "Fifteen-Thirty" 1 2
                              "Forty-Fifteen" 3 1
                              "Fifteen-Forty" 1 3
                              "Win for player1" 4 1
                              "Win for player2" 1 4

                              "Forty-Thirty" 3 2
                              "Thirty-Forty" 2 3
                              "Win for player1" 4 2
                              "Win for player2" 2 4

                              "Advantage player1" 4 3
                              "Advantage player2" 3 4
                              "Advantage player1" 5 4
                              "Advantage player2" 4 5
                              "Advantage player1" 15 14
                              "Advantage player2" 14 15

                              "Win for player1" 6 4
                              "Win for player2" 4 6
                              "Win for player1" 16 14
                              "Win for player2" 14 16

                              )
  )