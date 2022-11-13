(ns rich4clojure.easy.problem-153
  (:require
   [clojure.set :as set]
   [hyperfiddle.rcf :refer [tests]]))

;; = Pairwise Disjoint Sets =
;; By 4Clojure user: maximental
;; Difficulty: Easy
;; Tags: [set-theory]
;;
;; Given a set of sets, create a function which returns
;; true if no two of those sets have any elements in
;; common 1 and false otherwise. Some of the test cases
;; are a bit tricky, so pay a little more attention to
;; them.
;;
;;
;; 1 Such sets are usually called pairwise disjoint or
;; mutually disjoint .

;;my solution
(def __
  (fn [set-of-sets]
    (loop [acc (first set-of-sets)
           sets set-of-sets]
      (cond
        (= (count sets) 1)
        true

        (seq (set/intersection (second sets) acc))
        false

        :else
        (recur (into acc (second sets)) (rest sets))))))

(comment

  (defn __ [coll]
    (= (count (apply set/union coll))
       (apply + (map count coll))))

  ;;if the union is == to the total number,
  ;; then there are no repeats
  (count (apply set/union #{#{1 9 8} #{2 3 5}}))
  (apply + (map count #{#{1 2 3} #{2 3 4}}))


  ;;what is set/union?
  (set/union #{3 4 5 6} #{6 7 8})
  ;;combination of all sets
  )

(tests
 (__ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}}) :=
 true
 (__ #{#{:a :b :c :d :e}
       #{:a :b :c :d}
       #{:a :b :c}
       #{:a :b}
       #{:a}}) :=
 false
 (__ #{#{[1 2 3] [4 5]}
       #{[1 2] [3 4 5]}
       #{[1] [2] 3 4 5}
       #{1 2 [3 4] [5]}}) :=
 true
 (__ #{#{'a 'b}
       #{'c 'd 'e}
       #{'f 'g 'h 'i}
       #{''a ''c ''f}}) :=
 true
 (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
       #{#{:x :y :z} #{:x :y} #{:z} #{}}
       #{'[:x :y :z] [:x :y] [:z] [] {}}}) :=
 false
 (__ #{#{(= "true") false}
       #{:yes :no}
       #{(class 1) 0}
       #{(symbol "true") 'false}
       #{(keyword "yes") ::no}
       #{(class '1) (int \0)}}) :=
 false
 (__ #{#{distinct?}
       #{#(-> %) #(-> %)}
       #{#(-> %) #(-> %) #(-> %)}
       #{#(-> %) #(-> %) #(-> %)}}) :=
 true
 (__ #{#{(#(-> *)) + (quote mapcat) #_nil}
       #{'+ '* mapcat (comment mapcat)}
       #{(do) set contains? nil?}
       #{#_empty?}}) :=
 false)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/2993425c507c8be6d1abeae28f8e2511
