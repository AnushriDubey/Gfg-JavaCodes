public class MemoryConsumption {

    public static int mem(int i, int m1, int m2) {
        if(m1 < i && m2 < i) return i;
        else {

            if(m1 > m2) return mem(i+1, m1-i, m2);
            else return mem(i+1, m1, m2-i);
        }
    }
}
