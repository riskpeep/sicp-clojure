;Exercise 1.18:
;
;  Using the results of Exercise 1.16 and Exercise 1.17, devise a procedure
;  that generates an iterative process for multiplying two integers in terms
;  of adding, doubling, and halving and uses a logarithmic number of steps.
;
;  (This algorithm, which is sometimes known as the “Russian peasant method” of
;  multiplication, is ancient. Examples of its use are found in the Rhind
;  Papyrus, one of the two oldest mathematical documents in existence, written
;  about 1700 B.C. (and copied from an even older document) by an Egyptian
;  scribe named A’h-mose.)

;; First, we provide naieve implementations of double and halve
(defn double [a]
   (+ a a))

(defn even? [n]
   (= (rem n 2) 0))

(defn halve [a]
   (cond (even? a) (/ a 2)
         :else a))

;; Now we may proceed with the observation that
;;
;;          b
;; b = 2 * ---
;;          2
;;
;; Addtionally, we observe the following
;;
;; Given a and b such that (a * b) = n, the following is true for all a, b,
;; and n
;;
;; (a * b)       = n
;;           b
;; (a * 2 * ---) = n
;;           2
;;
;;        b
;; (2a * ---)    = n
;;        2
;;
;; Using this observation, we can proceed by creating a function that

(defn fast-*-iter [a b c]
   (cond (= b 0) c
         (not (even? b)) (fast-*-iter a (- b 1) (+ c a))
         :else (fast-*-iter (double a) (halve b) c)))

(defn fast-* [a b]
   (fast-*-iter a b 0))

(= 0 (fast-* 1 0))
(= 0 (fast-* 0 1))
(= 1 (fast-* 1 1))
(= 2 (fast-* 1 2))
(= 4 (fast-* 2 2))
(= 8 (fast-* 2 4))
(= 16 (fast-* 4 4))
(= 20 (fast-* 4 5))
