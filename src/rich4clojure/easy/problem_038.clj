(ns rich4clojure.easy.problem-038
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Maximum value =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [core-functions]
;;
;; Write a function which takes a variable number of
;; parameters and returns the maximum value.

(def restricted [max max-key])

(def first-attempt
  (fn [& args]
    (let [initial-list args]
      (letfn [(get-max [l]
                (let [idx0 (first l)
                      idx1 (second l)]
                 (cond
                  (= 2 (count l))
                  (if (> idx0 idx1)
                    idx0
                    idx1)

                  (> idx0 idx1)
                  (get-max (cons idx0 (rest (rest l))))

                  (> idx1 idx0)
                  (get-max (rest l)))))]
        (get-max initial-list)))))

(def __
  (fn [& args]
    (let [initial-list args]
      (reduce (fn [a b] (if (> a b) a b)) initial-list))))

(comment)

(tests
 (__ 1 8 3 4) := 8
 (__ 30 20) := 30
 (__ 45 67 11) := 67)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/3d8cce63160543ce69b40bc041174b28
