(ns tennis.tennis-game3
  (:gen-class))

(def p1 (atom 0))

(def p2 (atom 0))

(defn get-score []
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

(defn won-point [player_name]
  ;(do
    (println "hello")

    ;(cond
    ;  (= player_name "player1") (reset! p1 (inc @p1))
    ;  :else (reset! p2 (inc @p2))
    ;  )

    ;)
  )

(defn print-it []
  (println "printing...")
  )