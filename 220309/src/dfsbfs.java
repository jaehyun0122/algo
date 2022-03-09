import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfsbfs {

    static int[][] adjMatrix;
    static int n,m,start;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        adjMatrix = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }
        boolean[] visited = new boolean[n+1];
        dfs(start, visited);
        System.out.println();
        visited = new boolean[n+1];
        bfs(start, visited);
    }

    static void dfs(int cur, boolean[] visited){
        visited[cur] = true;
        System.out.print(cur+" ");
        for(int i=1; i<=n; i++){
            if(!visited[i] && adjMatrix[cur][i] == 1){
                dfs(i, visited);
            }
        }
    }

    static void bfs(int cur, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        visited[cur] = true;

        while(!q.isEmpty()){
            cur = q.poll();
            System.out.print(cur+" ");
            for(int i=1; i<=n; i++){
                if(!visited[i] && adjMatrix[cur][i] == 1){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }

    }
}
