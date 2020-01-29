(ns tennis.tennis-game
  (:gen-class))

(defprotocol TennisGame
  (get-score [this])
  (won-point [this player_name])
  )