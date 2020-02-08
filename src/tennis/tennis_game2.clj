(ns tennis.tennis-game2
  (:require [tennis.tennis-game :refer :all]))

(def P1point (atom 0))
(def P2point (atom 0))

(defn less-than-4 []
  (if (and (= @P1point @P2point) (< @P1point 4))
    (let [score (cond
                  (= @P1point 0) "Love"
                  (= @P1point 1) "Fifteen"
                  (= @P1point 2) "Thirty"
                  )]
      (str score "-All")
      )
    "")
  )

(defn deuce [score p1point]
  (if (and (= @P1point @P2point) (>= p1point 3))
    "Deuce"
    score
    )
  )

(defn p2love [score]
  (if (and (> @P1point 0) (= @P2point 0))
    (let [P1res (cond
                  (= @P1point 1) "Fifteen"
                  (= @P1point 2) "Thirty"
                  (= @P1point 3) "Forty"
                  )
          P2res (str "Love")]
      (str P1res "-" P2res)
      )
    score
    )
  )

(defn p1love [score]
  (if (and (> @P2point 0) (= @P1point 0))
    (let [P2res (cond
                  (= @P2point 1) "Fifteen"
                  (= @P2point 2) "Thirty"
                  (= @P2point 3) "Forty"
                  )
          P1res (str "Love")]
      (str "Love" "-" P2res)
      )
    score
    )
  )

(defn do-p1point [score]
  (if (and (> @P1point @P2point) (< @P1point 4))
    (let [P1res (cond
                  (= @P1point 2) "Thirty"
                  (= @P1point 3) "Forty"
                  )
          P2res (cond
                  (= @P2point 1) "Fifteen"
                  (= @P2point 2) "Thirty"
                  )
          ]
      (str P1res "-" P2res)
      )
    score
    )
  )

(defn do-p2point [score]
  (if (and (> @P2point @P1point) (< @P2point 4))
    (let [P2res (cond
                  (= @P2point 2) "Thirty"
                  (= @P2point 3) "Forty"
                  )
          P1res (cond
                  (= @P1point 1) "Fifteen"
                  (= @P1point 2) "Thirty"
                  )
          ]
      (str P1res "-" P2res)
      )
    score
    )
  )

(defn advantage-p1 [score p1point p2point]
  (if (and (> p1point p2point) (>= p2point 3))
    "Advantage player1"
    score
    )
  )

(defn advantage-p2 [score p2point p1point]
  (if (and (> p2point p1point) (>= p1point 3))
    "Advantage player2"
    score
    )
  )

(defn player1-win [score p1point p2point]
  (if (and (>= p1point 4) (>= p2point 0) (>= (- p1point p2point) 2))
    "Win for player1"
    score
    )
  )

(defn player2-win [score p2point p1point]
  (if (and (>= p2point 4) (>= p1point 0) (>= (- p2point p1point) 2))
    "Win for player2"
    score
    )
  )

(defrecord TennisGame2 [player1Name player2Name]
  TennisGame
  (get-score [_]
    (->
      (less-than-4)
      (deuce @P1point)
      (p2love)
      (p1love)
      (do-p1point)
      (do-p2point)
      (advantage-p1 @P1point @P2point)
      (advantage-p2 @P2point @P1point)
      (player1-win @P1point @P2point)
      (player2-win @P2point @P1point)
      )
    )
  )