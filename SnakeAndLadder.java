import java.util.*;
public class SnakeAndLadder {

    static Map<Integer, Integer> mp;
    static class QueueEntry{
        int v, dist;
        QueueEntry(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        public String toString() {
            return "[" + this.v + ", " + this.dist + "]";
        }
    }

    static int throwsCnt() {
        int visited[] = new int[30];
        Queue<QueueEntry> q = new LinkedList<>();
        QueueEntry qe = new QueueEntry(0, 0);
        visited[0] = 1;
        q.add(qe);
        int n = 30;
        while(!q.isEmpty()) {
            qe = q.poll();
            int v = qe.v;
            if(v == (n-1)) break;
            for(int j=(v+1); j<=(v+6) && j<n;j++) {
                if(visited[j] == 0) {
                    QueueEntry a = new QueueEntry(j, qe.dist+1);
                    visited[j] = 1;
                    if(mp.containsKey(j)) a.v = mp.get(j);
                    q.add(a);
                }
            }
            System.out.println(q);
        }
        return qe.dist;
    }
    static int minThrow(int N, int a[]){
        mp = new HashMap<>();
        for(int i=0;i<2*N;i++) {
            if(i%2==0) mp.put(a[i]-1, a[i+1]-1);
        }
        //System.out.println(mp);
        return throwsCnt();
    }



    public static void main(String args[]) {
        int a[] = {22,9};
        int N = 1;
        System.out.println(minThrow(N,a));
    }
}
