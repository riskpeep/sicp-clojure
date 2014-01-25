;Exercise 1.4:
;
;  Observe that our model of evaluation allows for combinations whose
;  operators are compound expressions.  Use this observation to describe
;  the behavior of the following procedure:
;
;  (define (a-plus-abs-b a b)
;    ((if (> b 0) + -) a b))

;;  This method adds the absolute value of b to the value a
;;  It works by evaluating a function of b to determine the operator to use
;;  on the operands a and b.
;;  We can confirm that we have identified a correct solution by showing the
;;  equality of two evaluations with similar operands where a'= a and b' = -b

;;  Re-writing in clojure yeilds
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(= (a-plus-abs-b 5 7) (a-plus-abs-b 5 -7))