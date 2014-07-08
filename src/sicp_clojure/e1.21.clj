;Exercise 1.21:
;
;  Use the smallest-divisor procedure to find the smallest divisor of each of
;  the following numbers: 199, 1999, 19999.

;; From the text we have
;;
;; (define (smallest-divisor n) (find-divisor n 2))
;; (define (find-divisor n test-divisor)
;;    (cond ((> (square test-divisor) n) n)
;;          ((divides? test-divisor n) test-divisor)
;;          (else (find-divisor n (+ test-divisor 1)))))
;; (define (divides? a b) (= (remainder b a) 0))
;;
;; Re-writing in Clojure yields
(require ['clojure.math.numeric-tower :as 'math])

(defn square [a]
   (* a a))

(defn divides? [a b]
   (= (rem b a) 0))

(defn find-divisor [n test-divisor]
   (cond (> (square test-divisor) n) n
         (divides? test-divisor n) test-divisor
         :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
   (find-divisor n 2))

(= 199  (smallest-divisor 199))
(= 1999 (smallest-divisor 1999))
(= 7    (smallest-divisor 19999))
