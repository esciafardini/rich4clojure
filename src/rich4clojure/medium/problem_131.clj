(ns rich4clojure.medium.problem-131
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Sum Some Set Subsets =
;; By 4Clojure user: amcnamara
;; Difficulty: Medium
;; Tags: [math]
;;
;; Given a variable number of sets of integers, create a
;; function which returns true iff all of the sets have a
;; non-empty subset with an equivalent summation.

(def __ :tests-will-fail)

(comment

  (defn rotate [coll]
    (if (seq coll)
      (cons (last coll) (drop-last coll))
      '()))

  (rotate [99 1 2 5 6])

  (defn rotations [coll]
    (loop [mc coll
           counter (count mc)
           acc '()]
      (if (zero? counter)
        acc
        (recur (rotate mc) (dec counter) (cons (seq mc) acc)))))

  (conj #{} 34)

  (into '() [[1 2] [2 1]])

  (loop [coll-of-rotations (rotations [11 1 2 5])
         acc (into '() coll-of-rotations)]
         (if (seq (first coll-of-rotations))
           (recur (map rest coll-of-rotations) (into acc (map rest coll-of-rotations)))
           acc
           )
         )

  (rotations [11 1 2 5])


  (map rest x)



  (def surp [#{-1 1 99}
             #{-2 2 888}
             #{-3 3 7777}])
  ;;
  ;; how can I get all subsets

  (defn power-set
    " get powerset drop #{} sum num in each set"
    [in-s]
    (->> in-s
         (reduce #(into % (for [subset %] (conj subset %2))) #{#{}})
         (filter #(not= #{} %))
         (map #(reduce + (into [] %)))
         set))

  (reduce
    #(into %1 (for [subset %1] (conj subset %2)))
    #{#{}}
    #{1 2 5 9})



  (reduce
    #(into %1 (for [subset %1] (conj subset %2)))
    []
    #{1 2 5 9})

  (for [subset #{#{}}] (conj subset #{1 2 5 9}))

  (power-set #{1 2})

;;break it down  to all sets
  (defn somesum [s3t]
    (let [vs (vec s3t)
          cnt (count s3t)]
      (sort vs)))

  (somesum #{100 123 2412 1222})

  (def x 8))

(tests
 true :=  (__ #{-1 1 99}
              #{-2 2 888}
              #{-3 3 7777})
 false := (__ #{1}
              #{2}
              #{3}
              #{4})
 true :=  (__ #{1})
 false := (__ #{1 -3 51 9}
              #{0}
              #{9 2 81 33})
 true :=  (__ #{1 3 5}
              #{9 11 4}
              #{-3 12 3}
              #{-3 4 -2 10})
 false := (__ #{-1 -2 -3 -4 -5 -6}
              #{1 2 3 4 5 6 7 8 9})
 true :=  (__ #{1 3 5 7}
              #{2 4 6 8})
 true :=  (__ #{-1 3 -5 7 -9 11 -13 15}
              #{1 -3 5 -7 9 -11 13 -15}
              #{1 -1 2 -2 4 -4 8 -8})
 true :=  (__ #{-10 9 -8 7 -6 5 -4 3 -2 1}
              #{10 -9 8 -7 6 -5 4 -3 2 -1}))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/208b537ca9e4b62751cfa7aa4fdc2461
