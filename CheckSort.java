import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CheckSort {

    static class Demo{
        float p;
        Demo(float p) {
            this.p = p;
        }
        public String toString() {
            return this.p + "";
        }
    }
    public static void main(String args[]) {
        Demo d1 = new Demo(5);
        Demo d2 = new Demo(2);
        Demo d3 = new Demo(6);
        Demo d4 = new Demo(7);
        Demo d5 = new Demo(5);

        ArrayList<Demo> al = new ArrayList<>();
        al.add(d1);al.add(d2);al.add(d3);al.add(d4);al.add(d5);
        Collections.sort(al, new Comparator<Demo>() {
            @Override
            public int compare(Demo o1, Demo o2) {
                if((o1.p-o2.p) == 0) return 0;
                return (int) 1;
            }
        });
        System.out.println(al);
        System.out.println(d1.p-d5.p);
    }

}
