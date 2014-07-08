;Exercise 1.24:
;
;  Modify the timed-prime-test procedure of Exercise 1.22 to use fast-prime?
;  (the Fermat method), and test each of the 12 primes you found in that
;  exercise. Since the Fermat test has theta(log n) growth, how would you
;  expect the time to test primes near 1,000,000 to compare with the time
;  needed to test primes near 1000? Do your data bear this out? Can you explain
;  any discrepancy you find?

;; First, we define some methods we'll need
(require ['clojure.math.numeric-tower :as 'math])

(defn square [a]
   (* a a))

(defn divides? [a b]
   (= (rem b a) 0))

;
;; From the text (Sec 1.26), we have
;;
;; (define (expmod base exp m)
;;    (cond ((= exp 0) 1)
;;          ((even? exp)
;;              (remainder
;;                  (square (expmod base (/ exp 2) m))
;;                  m))
;;          (else
;;              (remainder
;;                  (* base (expmod base (- exp 1) m))
;;                  m))))
;;
;; (define (fermat-test n)
;; (define (try-it a)
;;    (= (expmod a n n) a))
;;    (try-it (+ 1 (random (- n 1)))))
;;
;; (define (fast-prime? n times)
;;    (cond ((= times 0) true)
;;          ((fermat-test n) (fast-prime? n (- times 1)))
;;          (else false)))
;;
;; Re-writing in Clojure yields
(defn expmod [base exp m]
   (cond (= exp 0) 1
         (even? exp)
             (rem
                 (square (expmod base (/ exp 2) m))
                 m)
         :else
             (rem
                 (* base (expmod base (- exp 1) m))
                 m)))

(defn fermat-test [n]
   (defn try-it [a]
      (= (expmod a n n) a))
   (try-it (+ 1 (rand (- n 1)))))

(defn fast-prime? [n times]
   (cond (= times 0) true
         (fermat-test n) (fast-prime? n (- times 1))
         :else false))

(defn report-prime [ elapsed-time ]
   (print " *** ")
   (print elapsed-time))

(defn start-prime-test [n start-time]
   (if (fast-prime? n)
       (report-prime (- (runtime) start-time))))

(defn timed-prime-test [n]
   (newline)
   (display n)
   (start-prime-test n (runtime)))
