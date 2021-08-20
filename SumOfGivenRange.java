import java.awt.*;
import java.util.Arrays;

public class SumOfGivenRange {
    static class Point{
        int val;
        int l, r;
        Point(int val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
        public String toString() {
            return "["+ this.val + " " + this.l + " " + this.r + "]";
        }
    }

    static Point seg[];
    public static int createSegmentTree(int a[], int l, int r, int i) {
        if(l==r) {
            seg[i] = new Point(a[l],l,r);
            return seg[i].val;
        }
        int mid = l + (r-l)/2;
        seg[i] = new Point(createSegmentTree(a,l,mid,2*i+1) + createSegmentTree(a, mid+1, r, 2*i+2), l, r);
        return seg[i].val;
    }

    public static int getSum(int l, int r, int ql, int qr, int i){
        if(l>qr || r<ql) return 0; // no overlap
        if(l>=ql && r<=qr) return seg[i].val; //total overlap
        else {
            int mid = l + (r-l)/2;
            return getSum(l,mid,ql,qr,2*i+1) + getSum(mid+1, r, ql,qr,2*i+2);
        }
    }

    public static void update(int diff, int l, int r, int i, int j) {
        if(i>r || i<l) return;
        if(l == r) {
            seg[j].val += diff;
            return;
        }
        if(l<=i && r>=i) {
            seg[j].val += diff;
            int mid = l + (r-l)/2;
            update(diff,l,mid,i,2*j+1);
            update(diff,mid+1,r,i,2*j+2);
        }
    }

    public static void main(String args[]) {
        int a[] = {1, 3, 5, 7, 9, 11};
        int n = a.length;
        seg = new Point[2*n+2];
        createSegmentTree(a,0,n-1, 0);
        System.out.println(Arrays.toString(seg));
        System.out.println(getSum(0,5,1,4,0));
        update(8,0,5,3,0);
        System.out.println(Arrays.toString(seg));
    }
}
