/*

The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

Input: arr[] = {3, 10, 2, 1, 20}
Output: Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input: arr[] = {3, 2}
Output: Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input: arr[] = {50, 3, 10, 7, 40, 80}
Output: Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

*/



public class Main {

    // Method 1 : Recursion 
    //     Optimal Substructure
    //         L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
    //         L(i) = 1, if no such j exists.

    //         Input  : arr[] = {3, 10, 2, 11}
    //         f(i): Denotes LIS of subarray ending at index 'i'

    //         (LIS(1)=1)

    //             f(4)  {f(4) = 1 + max(f(1), f(2), f(3))}
    //         /    |    \
    //         f(1)  f(2)  f(3) {f(3) = 1, f(2) and f(1) are > f(3)}
    //             |      |  \
    //             f(1)  f(2)  f(1) {f(2) = 1 + max(f(1)}
    //                     |
    //                     f(1) {f(1) = 1}

    //     Time Complexity: The time complexity of this recursive approach is exponential as there is a case of overlapping subproblems as explained in the recursive tree diagram above.
    // Auxiliary Space: O(1). No external space used for storing values apart from the internal stack space.

    static int max;

    public static int recursiveLIC(int[] a, int n){
        if(n==0) return 1;
        int curr_max = 1;
        for(int i=0;i<n;i++){
            int res = 1 + recursiveLIC(a, i);
            if(a[i] < a[n] && res > curr_max){
                curr_max = res;
            }
        }

        if(curr_max > max) {
            max = curr_max;
        }
        
        return curr_max;
    }

    public static int lic(int[] a, int n){
        max = 1;

        recursiveLIC(a, n-1);

        return max;
    }

    // Method 2 : Dynamic Programming
    // The simulation of approach will make things clear: 
    

    // Input  : arr[] = {3, 10, 2, 11}
    // LIS[] = {1, 1, 1, 1} (initially)
    // Iteration-wise simulation : 
    

    // arr[2] > arr[1] {LIS[2] = max(LIS [2], LIS[1]+1)=2}
    // arr[3] < arr[1] {No change}
    // arr[3] < arr[2] {No change}
    // arr[4] > arr[1] {LIS[4] = max(LIS [4], LIS[1]+1)=2}
    // arr[4] > arr[2] {LIS[4] = max(LIS [4], LIS[2]+1)=3}
    // arr[4] > arr[3] {LIS[4] = max(LIS [4], LIS[3]+1)=3}

    // Time Complexity: O(n2). 
    // As nested loop is used.
    // Auxiliary Space: O(n). 
    // Use of any array to store LIS values at each index.

    public static int dpLIC(int[] a, int n){
        int[] l = new int[n];
        for(int i=0;i<n;i++){
            l[i] = 1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[j]<a[i] && l[i]<l[j]+1){
                    l[i] = l[j] + 1;
                }
            }
        }

        int peakMax = 1;
        for(int i=0;i<n;i++){
            if(l[i]>max){
                max = l[i];
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int a[] = new int[]{22, 103, 11, 45, 54, 64, 12, 22, 46, 99, 1, 15};
        System.out.println("Recursive : " + lic(a, a.length));
        System.out.println("Dynamic Programming : " + dpLIC(a, a.length));
    }
}

