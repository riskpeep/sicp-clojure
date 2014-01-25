;Exercise 1.10:
;
;  The following procedure computes a mathematical function called Ackermann’s
;  function.
;
;  (define (A x y)
;     (cond ((= y 0) 0)
;           ((= x 0) (* 2 y))
;           ((= y 1) 2)
;           (else (A (- x 1) (A x (- y 1))))))
;
;  What are the values of the following expressions?
;  (A 1 10)
;  (A 2 4)
;  (A 3 3)
;
;  Consider the following procedures, where A is the procedure defined above:
;  (define (f n) (A 0 n))
;  (define (g n) (A 1 n))
;  (define (h n) (A 2 n))
;  (define (k n) (* 5 n n))
;
;  Give concise mathematical definitions for the functions computed by the
;  procedures f, g, and h for positive integer values of n. For example,
;  (k n) computes 5n^2.

;; Re-writing in clojure yeilds
(defn A [x y]
   (cond (= y 0) 0
         (= x 0) (* 2 y)
         (= y 1) 2
         :else (A (- x 1) (A x (- y 1)))))


;; (A 1 10)
;; (A 0 (A 1 9))
;; (A 0 (A 0 (A 1 8)))
;; (A 0 (A 0 (A 0 (A 1 7))))
;; (A 0 (A 0 (A 0 (A 0 (A 1 6)))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 5))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 4)))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 3))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 2)))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 1))))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2)))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4))))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 8)))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 16))))))
;; (A 0 (A 0 (A 0 (A 0 (A 0 32)))))
;; (A 0 (A 0 (A 0 (A 0 64))))
;; (A 0 (A 0 (A 0 128)))
;; (A 0 (A 0 256))
;; (A 0 512)
;; 1024
(= 1024 (A 1 10))

;; (A 2 4)
;; (A 1 (A 2 3))
;; (A 1 (A 1 (A 2 2)))
;; (A 1 (A 1 (A 1 (A 2 1))))
;; (A 1 (A 1 (A 1 2)))
;; (A 1 (A 1 (A 0 (A 1 1)))
;; (A 1 (A 1 (A 0 2)))))
;; (A 1 (A 1 4))))
;; (A 1 (A 0 (A 1 3))))
;; (A 1 (A 0 (A 0 (A 1 2)))))
;; (A 1 (A 0 (A 0 (A 0 (A 1 1))))))
;; (A 1 (A 0 (A 0 (A 0 2)))))
;; (A 1 (A 0 (A 0 4))))
;; (A 1 (A 0 8)))
;; (A 1 16)
;; (A 0 (A 1 15))
;; (A 0 (A 0 (A 1 14)))
;; (A 0 (A 0 (A 0 (A 1 13)))
;; (A 0 (A 0 (A 0 (A 0 (A 1 12)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 11)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 10)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 9)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 8)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 7)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 6)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 5)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 4)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 3)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 2)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 1)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 8)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 16)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 32)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 64)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 128)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 256)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 512)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 1024)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 2048)))
;; (A 0 (A 0 (A 0 (A 0 4096)))
;; (A 0 (A 0 (A 0 8192)))
;; (A 0 (A 0 16384)))
;; (A 0 32768)))
;; 65536
(= 65536 (A 2 4))

;; (A 3 3)
;; (A 2 (A 3 2))
;; (A 2 (A 2 (A 3 1)))
;; (A 2 (A 2 2))
;; (A 2 (A 1 (A 2 1))
;; (A 2 (A 1 2))
;; (A 2 (A 0 (A 1 1))
;; (A 2 (A 0 2))
;; (A 2 4)
;; (A 1 (A 2 3))
;; (A 1 (A 1 (A 2 2)))
;; (A 1 (A 1 (A 1 (A 2 1))))
;; (A 1 (A 1 (A 1 2)))
;; (A 1 (A 1 (A 0 (A 1 1)))
;; (A 1 (A 1 (A 0 2)))))
;; (A 1 (A 1 4))))
;; (A 1 (A 0 (A 1 3))))
;; (A 1 (A 0 (A 0 (A 1 2)))))
;; (A 1 (A 0 (A 0 (A 0 (A 1 1))))))
;; (A 1 (A 0 (A 0 (A 0 2)))))
;; (A 1 (A 0 (A 0 4))))
;; (A 1 (A 0 8)))
;; (A 1 16)
;; (A 0 (A 1 15))
;; (A 0 (A 0 (A 1 14)))
;; (A 0 (A 0 (A 0 (A 1 13)))
;; (A 0 (A 0 (A 0 (A 0 (A 1 12)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 11)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 10)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 9)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 8)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 7)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 6)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 5)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 4)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 3)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 2)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 1 1)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 8)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 16)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 32)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 64)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 128)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 256)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 512)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 1024)))
;; (A 0 (A 0 (A 0 (A 0 (A 0 2048)))
;; (A 0 (A 0 (A 0 (A 0 4096)))
;; (A 0 (A 0 (A 0 8192)))
;; (A 0 (A 0 16384)))
;; (A 0 32768)))
;; 65536
(= 65536 (A 3 3))

;  Consider the following procedures, where A is the procedure defined above:
;  (define (f n) (A 0 n))
;  (define (g n) (A 1 n))
;  (define (h n) (A 2 n))
;  (define (k n) (* 5 n n))
;
;  Give concise mathematical definitions for the functions computed by the
;  procedures f, g, and h for positive integer values of n. For example,
;  (k n) computes 5n**2.


;; (define (f n) (A 0 n))
;; f computes 2n
(defn f [n]
  (A 0 n))

(= 0 (f 0))
(= 2 (f 1))
(= 4 (f 2))
(= 8 (f 4))
(= 16 (f 8))
(= 32 (f 16))
(= 65536 (f 32768))

;; (define (g n) (A 1 n))
;; g computes 2^n
(defn g [n]
  (A 1 n))

(= 2 (g 1))
(= 4 (g 2))
(= 8 (g 3))
(= 16 (g 4))
(= 256 (g 8))
(= 65536 (g 16))


;; (define (h n) (A 2 n))
;; h computes 2^(h (- n 1))
;; Didn't figure this one out.
;; Looking here: http://www.billthelizard.com/2009/11/sicp-exercises-19-and-110.html
;; explains it
(defn h [n]
  (A 2 n))

(h 0)
(h 1)
(h 2)
(h 3)
(h 4)