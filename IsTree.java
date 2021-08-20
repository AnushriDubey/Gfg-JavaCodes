package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class IsTree {
    public void testing() throws IOException{
        throw new IOException("");
    }
    static ArrayList<ArrayList<Integer>> a;
    static int vis[];
    static boolean cycle = false, moreCom = false;
    public static void dfs(int i) {
        for(int j=0;j<a.get(i).size();j++) {
            int vertex = a.get(i).get(j);
            if(vis[vertex] != 0 &&  vis[i] != vertex && vis[i] != i) {
                //System.out.println("we reached here");
                cycle = true;
                return;
            }
            else if(vis[vertex] == 0) {
                vis[vertex] = i;
                dfs(vertex);
            }
        }

    }
    public static void main(String args[]) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        a = new ArrayList<>();
        for(int i=0;i<n+1;i++) a.add(new ArrayList<>());
        vis = new int[n+1];
        for(int i=0;i<e;i++) {
            String s1[] = br.readLine().split(" ");
            int st = Integer.parseInt(s1[0]);
            int en = Integer.parseInt(s1[1]);
            a.get(st).add(en);
            a.get(en).add(st);
        }
        int cnt = 0;
        for (int i=1;i<=n;i++) {
            if(cnt == 0 && vis[i] == 0) {
                vis[i] = i;
                cnt++;
                dfs(i);
            }
            else if(cnt >= 1 && vis[i] == 0) {
                //System.out.println("we reached here 2");
                moreCom = true;
                break;
            }
        }
        //for(ArrayList<Integer> aa: a) System.out.println(aa);
        //System.out.println(Arrays.toString(vis));
        //if(e == 0) System.out.println("NO");
        if(!moreCom && !cycle) System.out.println("YES");
        else System.out.println("NO");
    }
}
