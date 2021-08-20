import java.util.ArrayList;

public class Joseph {

    public static int joseph(int k, ArrayList<Integer> al, int i) {
        if(al.size() == 1) return al.get(0);
        int m=(i+k)%al.size();
        al.remove(m);
        return joseph(k,al,m);
    }
    public static void main(String args[]) {
        int n = 7, k = 2;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            al.add(i);
        }
        k = k-1;
        System.out.println(joseph(k,al,0));
    }
}
