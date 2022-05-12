import java.util.*;
import java.io.*;

public class 뱀과사다리게임16928 {

	static int[] ladder;
	static boolean[] check;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ladder = new int[101];
		check = new boolean[101];
		cnt = new int[101];
		
		for(int i=0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ladder[u] = v;
		}
		
		bfs();
		
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		cnt[1] = 0;
		q.add(1);
		check[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == 100) {
				System.out.println(cnt[cur]);
				return;
			}
			
			for(int i=1; i<=6; i++) {
				int next = cur+i;
				if(next > 100 || check[next]) continue;
				check[next] = true;
				
				if(ladder[next] != 0) {
					if(!check[ladder[next]]) {
						q.add(ladder[next]);
						check[ladder[next]] = true;
						cnt[ladder[next]] = cnt[cur]+1;
					}
				}else {
					q.add(next);
					cnt[next] = cnt[cur]+1;
				}
			}
		}
	}
}
