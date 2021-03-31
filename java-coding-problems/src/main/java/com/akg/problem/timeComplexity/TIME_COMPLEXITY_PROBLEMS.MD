# Time Complexities Problems
============================================================

## Question 1
Which of the following is not bounded by O(n^2)?

 a)	(15^10) * n + 12099
 b)	n^1.98
 c)	n^3 / (sqrt(n))
 d)	(2^20) * n
 
they simply want to ask which one has more complexity than O(n^2).
Bounded means Upper Limit ! 

=============================================================
Answer: n^3 / (sqrt(n))

### Solution Approach: 
Look at the order of growth. Which function grows faster than O(n^2) ?

### Complete Solution:

The order of growth of option (C) is n^2.5 which is higher than n^2.
Lets look at it with a different approach :

	f(n) = O(n^2) if
	f(n) <= C * n^2 for n > n0.

Lets look at every option one by one.

** Option 1 :(15^10) * n + 12099
    
    Lets say C = 16^10
    15^10 * n + 12099 < 16^10 * n^2 for n > 1.
    So, it is O(n^2).


** Option 2 : n^1.98

    C = 1.
    n^1.98 < n^2 for n > 1.
    So, its O(n^2) ```


** Option 3 : n^3 / (sqrt(n)) or n^2.5
    
    There is no possible combination of C and n0 possible

** Option 4 : 2^20 * n
    
    C = 2^20, n0 = 1
        2^20 * n <= 2^20 * n^2 for n > 1


### Other Solutions 1:
    (15^10) * n + 12099 -> Is a linear expression - can be represented as O(n)
    n^1.98 < N^2 —> ( Nearly quadratic )
    (2^20) * n --> linear -> O(n)
    n^3 / (sqrt(n)) --> From the initial glance, it does not seem to be linear…

Now if we consider n = 4, the last expression results in 32 which is not bounded as per the requirement (n^2 = 16 ).

Otherwise, if required, we can apply log, simplify the expression and check the output by considering the value of n as 4. The result would be greater than 4.


===============================================================



## Question 2
Which of the given options provides the increasing order of complexity of functions f1, f2, f3 and f4:

    f1(n) = 2^n

    f2(n) = n^(3/2)

    f3(n) = nLogn

    f4(n) = n^(Logn)

Options:
   a) f3, f2, f4, f1
   b) f3, f2, f1, f4
   c) f2, f3, f1, f4
   d) f2, f3, f4, f1
    
=============================================================
Answer: f3, f2, f4, f1

### Complete Solution:
Try to look at the values for functions for very large value of n.


### Other Solutions 1:
simple put a value of n.
and put a lager value .
lets assume we take n=1000;
f1=     2^1000
f2=     1000^(3/2)      = 1000 * 100
f3=     1000*log(1000)  = 1000 *4
f4=     1000^(log1000)  = 1000^4

here you can clearly see , which one is greater


===============================================================


## Question 2


=============================================================
Answer: 

### Solution Approach: 


### Complete Solution:



### Other Solutions 1:



===============================================================


## Question 2


=============================================================
Answer: 

### Solution Approach: 


### Complete Solution:



### Other Solutions 1:



===============================================================
