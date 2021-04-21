import java.io.*;

class Main {
    public static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l-1;
        for(int j=l;j<r;j++){
            if(a[j]<pivot){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        int temp = a[i];
        a[i] = pivot;
        a[r] = temp;
        return i;
    }
    public static void sort(int[] a, int l, int r) {
        if(l>r) return ;
        int p = partition(a, l, r);
        sort(a, l, p-1);
        sort(a, p+1, r);

    }
    public static void main(String[] args) {
        int a[] = new int[]{32, 43, 22, 12, 88, 0, 127, -45};
        sort(a, 0, a.length-1);
        // int p = partition(a, 0, a.length-1);
        for(int x: a){
            System.out.print(x + " ");
        }
        // System.out.println("\n" + p  + " ");
    }
}