import java.util.Arrays;
import java.util.Scanner;

public class Heaps {
    public static int parent(int i) { return i/2; }
    public static int left(int i) { return i*2+1;}
    public static int right(int i) { return i*2 + 2;}
    public static int extractMinMax(int a[], int n) {
        int t = a[0];
        a[0] = a[n-1];
        a[n-1] = t;
        n--;
        heapifyMin(a, 0, n);
        return t;
    }

    public static void heapifyMin(int a[], int i, int n){
        int mI = i;
        if(left(i)<n && a[left(i)] < a[mI]) mI = left(i);
        if(right(i) < n && a[right(i)] < a[mI]) mI = right(i);
        if(mI != i) {
            int t = a[i];
            a[i] = a[mI];
            a[mI] = t;
            heapifyMin(a, mI, n);
        }
    }

    public static void heapifyMax(int a[], int i, int n){
        int mI = i;
        if(left(i)<n && a[left(i)] > a[mI]) mI = left(i);
        else if(right(i) < n && a[right(i)] > a[mI]) mI = right(i);
        if(mI != i) {
            int t = a[i];
            a[i] = a[mI];
            a[mI] = t;
            heapifyMax(a, mI, n);
        }
    }

    public static void buildHeap(int a[], int n) {
        for(int i= n/2-1;i>=0;i--) {
            heapifyMin(a,i,n);
        }
    }
    public static void insert(int a[], int val, int n) {
        n = n+1;
        a[n] = val;
        heapifyMin(a, parent(n), n);
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = 4;
        int a[] = {7, 10, 4, 20, 15};
        int n = a.length;
        buildHeap(a, n);
        for(int i=0;i<k-1;i++) {
            extractMinMax(a,n);
            n = n-1;
        }
        System.out.println(extractMinMax(a,n));
        //System.out.println(Arrays.toString(a));
    }
}
