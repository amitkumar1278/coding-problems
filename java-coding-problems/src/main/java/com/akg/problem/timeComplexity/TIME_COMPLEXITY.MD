# Important Question on time complexity



### 1. What does it mean when we say that an algorithm X is asymptotically more efficient than Y?
    X will always be a better choice for large inputs

** Explanation **
    In asymptotic analysis we consider growth of algorithm in terms of input size. An algorithm X is said to be asymptotically better than Y if X takes smaller time than y for all input sizes n larger than a value n0 where n0 > 0.

    we have 2 Algorithms X and Y and X is more efficient then Y. So X will be a better choice for small as well as large input values if the efficiency of X is more then Y for small input values

    Some algorithms are more efficient when data size is small, But when data size starts to increase, efficiency of some algorithm is better than others. This is when we should say that some algorithms are asymptotically better than others; meaning, they become better as data grows.

    See when we say asymptote, it means something that is tending to infinity. So if you put asymptotic input that is n tending to infinity, how the function will perform at that time is what time complexity is. That is also the worst case scenario or the Big-O notation. So that means if X is Asymptotically efficient, then it will perform better with larger inputs and has less Big-O notation as compared to Y.


    