DYNAMIC PROGRAMMING : Dynamic Programming is an algorithmic paradigm that solves a given complex problem by breaking it into subproblems and stores the results of subproblems to avoid computing the same results again

1. Overlapping Subproblems : computed solutions to subproblems are stored in a table so that these don’t have to be recomputed. So Dynamic Programming is not useful when there are no common (overlapping) subproblems because there is no point storing the solutions if they are not needed again. Example : Fibonacci Series.
There  are two different ways to store the values so that these values can be used again.
    i. Memoization(Top Down)
    ii. Tabulation(Bottom Up)

2. Optimal Substructure : A given problems has Optimal Substructure Property if optimal solution of the given problem can be obtained by using optimal solutions of its subproblems. Example :  the Shortest Path problem has following optimal substructure property:
    If a node x lies in the shortest path from a source node u to destination node v then the shortest path from u to v is combination of shortest path from u to x and shortest path from x to v.

LONGEST INCREASING SUBSEQUENCE : 
    Method 1 : Recursion 
        Optimal Substructure
            L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
            L(i) = 1, if no such j exists.

            Input  : arr[] = {3, 10, 2, 11}
            f(i): Denotes LIS of subarray ending at index 'i'

            (LIS(1)=1)

                f(4)  {f(4) = 1 + max(f(1), f(2), f(3))}
            /    |    \
            f(1)  f(2)  f(3) {f(3) = 1, f(2) and f(1) are > f(3)}
                |      |  \
                f(1)  f(2)  f(1) {f(2) = 1 + max(f(1)}
                        |
                        f(1) {f(1) = 1}
        Complexity Analysis: 
            Time Complexity: The time complexity of this recursive approach is exponential as there is a case of overlapping subproblems as explained in the recursive tree diagram above.
            Auxiliary Space: O(1). No external space used for storing values apart from the internal stack space.   

    Method 2: Dynamic Programming.
        We can see that there are many subproblems in the above recursive solution which are solved again and again. So this problem has Overlapping Substructure property and recomputation of same subproblems can be avoided by either using Memoization or Tabulation.
        The simulation of approach will make things clear: 

        Input  : arr[] = {3, 10, 2, 11}
        LIS[] = {1, 1, 1, 1} (initially)
        Iteration-wise simulation : 
        
        arr[2] > arr[1] {LIS[2] = max(LIS [2], LIS[1]+1)=2}
        arr[3] < arr[1] {No change}
        arr[3] < arr[2] {No change}
        arr[4] > arr[1] {LIS[4] = max(LIS [4], LIS[1]+1)=2}
        arr[4] > arr[2] {LIS[4] = max(LIS [4], LIS[2]+1)=3}
        arr[4] > arr[3] {LIS[4] = max(LIS [4], LIS[3]+1)=3}

        Complexity Analysis: 
            Time Complexity: O(n2). 
            As nested loop is used.
            Auxiliary Space: O(n). 
            Use of any array to store LIS values at each index.