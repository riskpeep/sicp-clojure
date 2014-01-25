;Exercise 1.8:
;
;  Newton’s method for cube roots is based on the fact that if y is an
;  approximation to the cube root of x, then a better approximation is
;  given by the value
;
;   x/y^2 + 2y
;   -----------
;        3     .
;
;  Use this formula to implement a cube-root procedure analogous to the
;  square-root procedure. (In Section 1.3.4 we will see how to implement
;  Newton’s method in general as an abstraction of these square-root and
;  cube-root procedures.)

;; For our work, we'll need some basic functions
;; Re-writing in clojure yields
(defn square [x]
  (* x x ))

(defn cube [x]
  (* x x x))

(defn abs [x]
  (cond (< 0 x) x
        :else (- x)))

;; And now the methods we care about
(defn improve [guess x]
      (/ (+ (/ x (square guess))
            (* 2 guess))
         3))

(defn good-enough? [guess x]
      (< (abs (- guess (improve guess x))) (* guess 0.00001)))

(defn cube-iter [guess x]
   (if (good-enough? guess x)
        guess
       (cube-iter (improve guess x) x)))

(defn cube-rt [x]
  (cube-iter 1.0 x))

;; Here it works
(cube (cube-rt 5))
(cube (cube-rt 2))

;; Very small numbers
(cube (cube-rt 0.001))
(cube (cube-rt 0.0001))

;; Very large numbers
(cube (cube-rt 1.0E12))
(cube (cube-rt 1.0E13))