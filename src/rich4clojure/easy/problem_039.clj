(ns rich4clojure.easy.problem-039
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Interleave Two Seqs =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;;
;; Write a function which takes two sequences and returns
;; the first item from each, then the second item from
;; each, then the third, etc.

(def restricted [interleave])

(def __
  (fn [& colls]
    (loop [cs colls
           acc []]
      (if
       ;; are any of the colls empty?
       (seq (filter (fn [c] (not (seq c))) cs))
        acc
        (recur (map rest cs) (into acc (map first cs)))))))

(comment

  (defn weave [& colls]
    (loop [cs colls
           acc []]
      (if
       (seq (filter (fn [c] (not (seq c))) cs))
        acc
        (recur (map rest cs) (into acc (map first cs))))))

  (weave ["lol" "hee" "ha"] [5 4 3 2 1] [1 2 3] [:a :B :c]))

(tests
 (__ [1 2 3] [:a :b :c]) := '(1 :a 2 :b 3 :c)
 (__ [1 2] [3 4 5 6]) := '(1 3 2 4)
 (__ [1 2 3 4] [5]) := [1 5]
 (__ [30 20] [25 15]) := [30 25 20 15])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/65d3ee0ffa567e78927bbebbb9d9cc89
