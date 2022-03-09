import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {

    static class Node{
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }

    static int n,m;
    static boolean[][] adjMarix;



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int w = sc.nextInt();
        // 인접 행렬
        adjMarix = new boolean[n+1][m+1];

        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjMarix[from][to] = true;
            adjMarix[to][from] = true;
        }
        System.out.println("bfs--");
        bfs();
        System.out.println("dfs--");
        boolean[] visited = new boolean[n];
        dfs(0, visited);
    }
    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()){
            int cur = q.poll();
            System.out.println((char)(cur+'A'));

            for(int i=0; i<n; i++){
                if(!visited[i] && adjMarix[cur][i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }

        }
    }

    private static void dfs(int cur, boolean[] visited){

        visited[cur] = true;
        System.out.println((char)(cur+'A'));

        for(int i=0; i<n; i++){
            if(!visited[i] && adjMarix[cur][i]){
                dfs(i, visited);
            }
        }
    }


}
