import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 특정한최단경로 {

    static class path implements Comparable<path> {
        int b;//목적지
        int c;//가중치

        public path(int b, int c) {
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(path o) {
            return this.c - o.c;
        }
    }

    static int n,m,c;
    static ArrayList<path>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list[a].add(new path(b,c));
            list[b].add(new path(a,c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        long ans1=0, ans2 = 0;

        ans1 += solution(1, v1);
        ans1 += solution(v1, v2);
        ans1 += solution(v2, n);

        ans2 += solution(1, v2);
        ans2 += solution(v2, v1);
        ans2 += solution(v1, n);

        if(Math.min(ans1, ans2) >= Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(ans1, ans2));
    }

    static int[] dist;

    private static int solution(int start, int end) {
        PriorityQueue<path> q = new PriorityQueue<>();
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new path(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            path cur = q.poll();

            if (cur.c > dist[cur.b]) continue;
            for (path next : list[cur.b]) {
                if (dist[cur.b] + next.c < dist[next.b]) {
                    dist[next.b] = dist[cur.b] + next.c;
                    q.add(new path(next.b, dist[next.b]));
                }
            }
        }
        return dist[end];
    }
}
