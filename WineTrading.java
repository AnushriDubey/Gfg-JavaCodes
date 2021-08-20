import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WineTrading {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int cnt =0;
            if(n==0) break;
            else {
                int a[] = new int[n];
                for (int i=0;i<n;i++) a[i]= sc.nextInt();
                Queue<Integer> bq = new LinkedList<>();
                Queue<Integer> sq = new LinkedList<>();

                for(int i=0;i<n;i++) {
                    //System.out.println(sq);
                    //System.out.println(bq);
                    if(a[i] > 0) {
                        while(true) {
                            if(!sq.isEmpty()) {
                                int index = sq.peek();
                                int min = Math.min(a[i], -a[sq.peek()]);
                                a[i] = a[i]-min;
                                a[sq.peek()] += min;
                                cnt += Math.abs(i-index)*min;
                                if(a[sq.peek()]==0) sq.remove();
                                if(a[i] == 0) break;
                            }
                            else {
                                break;
                            }
                        }
                        if(a[i]!=0) bq.add(i);
                    }
                    else if(a[i] < 0) {
                        while (true) {
                            if (!bq.isEmpty()) {
                                int index = bq.peek();
                                int min = Math.min(-a[i], a[bq.peek()]);
                                a[i] = a[i] + min;
                                a[bq.peek()] -= min;
                                cnt += Math.abs(i - index) * min;
                                if (a[bq.peek()] == 0) bq.remove();
                                if (a[i] == 0) break;
                            } else {
                                break;
                            }
                        }
                        if(a[i]!=0) sq.add(i);
                    }
                    }
                }
            System.out.println(cnt);
            }
        }
    }
