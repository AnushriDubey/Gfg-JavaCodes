import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {
    static int target;
    static List<List<Integer>> hs;
    public static void cSum(int a[], int i, int sum,ArrayList<Integer> al) {
        if(i==a.length) {
            if(sum == 0) hs.add(al);
            else return;
        }
        else {
            if(sum>=a[i]) {
                ArrayList<Integer> al2 = new ArrayList<>();
                al2.addAll(al);
                al2.add(a[i]);
                cSum(a,i+1,sum-a[i], al2);
            }
            cSum(a,i+1,sum,al);
        }
    }


    public static int  cSum4(int a[], int i, int sum,ArrayList<Integer> al) {
        if(i==a.length) {
            if(sum == 0) return 1;
            else return 0;
        }
        else {
            if(sum>=a[i]) {
                ArrayList<Integer> al2 = new ArrayList<>();
                al2.addAll(al);
                al2.add(a[i]);
                return cSum4(a,i,sum-a[i], al2) + cSum4(a,i+1,sum,al);
            }
            else return cSum4(a,i+1,sum,al);
        }
    }



    public static void cSum3(int a[], int i, int sum,ArrayList<Integer> al, int k) {
        if(i==a.length) {
            if(sum == 0 && al.size()==k) hs.add(al);
            return;
        }
        else if(al.size()==k) {
            if(sum==0) hs.add(al);
            return;
        }
        else {
            if(sum>=a[i]) {
                ArrayList<Integer> al2 = new ArrayList<>();
                al2.addAll(al);
                al2.add(a[i]);
                cSum3(a,i+1,sum-a[i], al2,k);
            }
            cSum3(a,i+1,sum,al,k);
        }
    }


    public static void combination(int a[], int i, ArrayList<Integer> al, int k) {
        if(i==a.length) {
            if(al.size()==k) hs.add(al);
            return;
        }
        if(al.size()==k) hs.add(al);
        else {
                ArrayList<Integer> al2 = new ArrayList<>();
                al2.addAll(al);
                al2.add(a[i]);
                combination(a,i+1, al2,k);
                combination(a,i+1,al, k);
        }
    }
    public static void main(String args[]) {
        int a[] = {10,1,2,7,6,1,5};
        Arrays.sort(a);
        hs = new ArrayList<>();
        int n=4, b[]=new int[4], c[] = {1,2,3,4,5,6,7,8,9};
        for(int i=1;i<=n;i++) b[i-1]=i;
        //cSum(a,0,8,new ArrayList<>());
        //combination(b,0,new ArrayList<>(),2);

        cSum3(c,0,9,new ArrayList<>(),3);
        System.out.println(hs);
    }
}
