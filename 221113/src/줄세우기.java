import java.io.*;

import java.util.*;

public class 줄세우기 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[n+1];
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			
			list[front].add(back);
			indegree[back] += 1;
			
		}
		
		topologySort(list, indegree, n);
		
		
	}
	
	static void topologySort(ArrayList<Integer>[] list, int[] indegree, int n) {
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<indegree.length; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");	
			
			for(int next : list[cur]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb);
		
	}

}
