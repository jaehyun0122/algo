import java.util.*;
import java.io.*;

public class 깊이우선탐색124479 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[m+1];
		for(int i=1; i<=m; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for(int i=1; i<=n; i++) {
			Collections.sort(list[i]);
		}
		check = new boolean[n+1];
		dist = new ArrayList<>();
		dfs(r, m);
		ArrayList<Integer> res = new ArrayList<>();
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(dist.get(cnt) == i) {
				System.out.println(dist.get(i));
				cnt++;
			} else System.out.println(0);
		}
	}

	static boolean[] check;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> dist;
	
    static void dfs(int idx, int m){
        check[idx] = true;
        dist.add(idx);
        for(int i=0; i<list[idx].size(); i++){
    		int next = list[idx].get(i);
    		if(!check[next]) {
    			dfs(next, m);
    		}
        }
       
    }

}
