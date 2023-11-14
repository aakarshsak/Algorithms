import java.util.*;

public class Fibonacci {
    Map<Integer, Integer> map = new HashMap<>();

    public static int fibonacci(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n<=2) return 1;
        int fib = fibonacci(n-1) + fibonacci(n-2);
        map.put(n, fib);
        return fib;
    }

    public static void main(String args[]) {
        System.out.println("Nth Fibonacci: " + fibonacci(5));
    }
}