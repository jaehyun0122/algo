import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기11725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		int[] parents = new int[n+1];
		int start = 1;
		bfs(start, list, parents);
		
		for(int i=2; i<=n; i++) {
			System.out.println(parents[i]);
		}
	}

	static void bfs(int start, ArrayList<ArrayList<Integer>> list, int[] parents) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			for(int child : list.get(parent)) {
				if(parents[child] == 0) {
					parents[child] = parent;
					q.offer(child);
				}
			}
		}
	}
}
