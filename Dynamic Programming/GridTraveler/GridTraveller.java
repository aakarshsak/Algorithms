import java.util.*;
class HelloWorld {
    static Map<Long, Long> map = new HashMap<>();

    public static long gridTraveler(long m, long n) {
        if(m==0 || n==0) return 0;
        if((m==1 && n==2) || (m==2 && n==1)) return 1;
        if(m==2 && n==2) return 2;

        long down = gridTraveler(m-1, n);
        long right = gridTraveler(m, n-1);

        return down + right;

    }

    public static void main(String args[]) {
        System.out.println("Grid Traveler: " + gridTraveler(3, 3));
    }
}