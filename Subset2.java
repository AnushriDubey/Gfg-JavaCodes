import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Subset2 {

    static HashSet<List<Integer>> ls;
     public static void subset(int a[], int i, List<Integer> l) {
         if(i >= a.length) {
             ls.add(l);
             return;
         }
         if(l.size() == 0) {
             List<Integer> tmp = new ArrayList<>();
             tmp.add(a[i]);
             subset(a,i+1,tmp);
             subset(a,i+1,l);
         } else {
             List<Integer> tmp = new ArrayList<>();
             tmp.addAll(l);
             tmp.add(a[i]);
             subset(a,a.length,l);
             subset(a,i+1,tmp);
         }

     }

    public static void main(String args[]) {
        int a[] = {4,4,4,1,4};
        Arrays.sort(a);
        ls = new HashSet<>();
        subset(a,0,new ArrayList<>());
        System.out.println(ls);
    }
}
