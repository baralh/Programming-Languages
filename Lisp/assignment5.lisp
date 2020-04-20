;;Heman Baral
;;Assignment 5






;; Question 1
;;myList which creates 4 (7 22) "art" ("math" (8) 99) 100) list and returns it

(defun myList()
	(list 4 (list 7 22) "art" (list "math" (list 8) 99) 100)
)







;(defun leap-year-p (year)
 ; (flet ((is-divisible? (dividend divisor) (zerop (mod dividend divisor))))
   ; (or 
   ;   (and (is-divisible? year 4) (not (is-divisible? year 100)))
     ; (is-divisible? year 400))))



;;Question 2
;;returns an ordered list containing all leap years from 1800 though 2018
;;command to run (leapYear 1800)

(defun leapycount (year)
	(if 
	(= 0 (mod year 4 ))
	T			
	NIL			
	)
)

(let ((leaplist nil)(y 1800))
	
(defun leapYear (y)

	(if (> y 2018)

		(RETURN-FROM leapYear nil)
	)
	
    (leapYear (+ y 1))
	
	(if (leapycount y)

		(push y leaplist)
	)
	leaplist
)
)




;; Question 3
;;union-  takes two list parameters x y and returns one union list
(defun union- (x y)

    (cond ( (null x) y)

          ( (member (car x) y)

			(union- (cdr x) y)

		  )

          (T (cons (car x) (union- (cdr x) y) ) )
	)
)



;;Question 4
;;avg takes a single parameter named aList and returns the average of all elements in aList.

;;
(defun sum (aList)
	(if (equal aList nil) 0
        (+ (car aList) (sum (cdr aList)) )
    )
)


(defun avg (aList)
	(if 
        (equal aList nil) 0
        (/ (sum aList) (list-length aList) )

    )
)


;(defun count (aList a)
 ;(if (atom aList)
  ;   a
   ;  (count (cdr aList) (1+ a)) ))
;(defun sum (aList a)
; (if (atom aList)
   ;  a
  ;   (sum (cdr aList) (+ (car aList) a)) ))

;(defun avg (aList)
; (/ (sum aList 0) (count aList 0)))


;(print (avg '(1 3 2 8 7)))





;;Problem 5
;;isType returns an anonymous function which takes a single parameter and returns true
;;(isType 'String) Returns: #<FUNCTION (LAMBDA (DATATYPE) :IN ISTYPE) {2256923B}>


(defun isType (dataType)
 (lambda (dataType) (* dataType dataType))
               (lambda (dataType) (* dataType dataType))
               )


;; Question 6
;;taxCalculator takes three parameters: limit, rate, and values. 
;;limit and rate is a numbers, values is a list


(let ((output nil))

(defun taxCalculator (limit rate values)

	( if (equal values nil) (return-from taxCalculator nil) )

	(taxCalculator limit rate (cdr values) )

	( setq val2 (car values) )


	(let((val1 val2))

	(cond ((> val2 limit) (setq val1 (* val2 rate))) )

	(push val1 output)
)
)
)


;;Question 7

;;It takes two parameters aFunc and aList


(defun clean (aFunc aList)

 (if ( (= 0 (length aList)) 

 	NIL

  (if (listp (car aList))

   (cons (clean aFunc (car aList)) (clean aFunc (cdr aList)))

   ;;Checking if aList contains sublists or not
   ;;if it does than clean should create a new sublist with only the values which return true when passed to aFunc

   (if (funcall aFunc (car aList))

	(cons (car aList) (clean aFunc (cdr aList)))

	(clean aFunc (cdr aList))

   )

  )

 )

 )

 )

;;Question 8
;;This is a macro named threeWayBranch which takes three parameters, x y and toExecute. 
;;x and y will be numbers and toExecute a list with three sublists.

(defmacro threeWayBranch (x y toExecute)

	(if (= 0 (length toExecute) ) NIL
			 
				(cdr toExecute)
			
	)

	(if (( > x y) ((car (cdr toExecute) )))

		((< x y) ((car toExecute)))

		(((car (cdr (cdr toExecute)))))

		)
)
	





