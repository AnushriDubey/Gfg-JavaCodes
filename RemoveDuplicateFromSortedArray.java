import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static int lenArray(int a[]) {
        int len = a.length;
        int prev = a[0], cnt = 1, j = Integer.MAX_VALUE;
        boolean flag = false;
       for(int i=1;i<a.length;i++) {
            if(a[i] == prev) {
                cnt++;
                if(cnt > 2) {
                    a[i] = Integer.MAX_VALUE;
                    if(!flag) {
                        j = i;
                        flag = true;
                    }
                }
            }
            else {
                if(cnt > 2) len = len - (cnt-2);
                prev = a[i];
                cnt = 1;
            }
        }
        if(cnt > 2) len = len - (cnt-2);
        for(int k=0;k<a.length;k++) {
            if(a[k] != Integer.MAX_VALUE && k>j) {
                int t = a[k];
                a[k]= a[j];
                a[j] = t;
            }
            while(j<a.length && a[j] != Integer.MAX_VALUE) j++;
        }
        return len;
    }

    public static void main(String args[]) {
        //int a[] = {-50,-50,-49,-48,-47,-47,-47,-46,-45,-43,-42,-41,-40,-40,-40,-40,-40,-40,-39,-38,-38,-38,-38,-37,-36,-35,-34,-34,-34,-33,-32,-31,-30,-28,-27,-26,-26,-26,-25,-25,-24,-24,-24,-22,-22,-21,-21,-21,-21,-21,-20,-19,-18,-18,-18,-17,-17,-17,-17,-17,-16,-16,-15,-14,-14,-14,-13,-13,-12,-12,-10,-10,-9,-8,-8,-7,-7,-6,-5,-4,-4,-4,-3,-1,1,2,2,3,4,5,6,6,7,8,8,9,9,10,10,10,11,11,12,12,13,13,13,14,14,14,15,16,17,17,18,20,21,22,22,22,23,23,25,26,28,29,29,29,30,31,31,32,33,34,34,34,36,36,37,37,38,38,38,39,40,40,40,41,42,42,43,43,44,44,45,45,45,46,47,47,47,47,48,49,49,49,50};
        int a[] = {1,1,1,1,2,3,3,3,3,5};
        System.out.println(a.length);
        int len = lenArray(a);
        System.out.println(len);
        for(int i=0;i<len;i++) System.out.print(a[i] + ", ");
        System.out.println();
    }
}
