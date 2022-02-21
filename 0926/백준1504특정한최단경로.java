import java.util.*;

class path implements Comparable<path>{
	// 도착지
	int b;
	// 거리
	int c;
	path(int b, int c){
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(path o) {
		// TODO Auto-generated method stub
		return this.c - o.c;
	}
	
}

public class 백준1504특정한최단경로 {

	
	static int n,m,v1, v2;
	static ArrayList<path>[] list;
	static int INF = Integer.MAX_VALUE;
	static int[] dist;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// m개의 노드 정보입력.
		for(int i=0;i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// 양방향이므로 
			list[a].add(new path(b, c));
			list[b].add(new path(a, c));
		}
		
		// 반드시 거쳐가야되는 정점.
		v1 = sc.nextInt();
		v2 = sc.nextInt();
		// start -> v1 -> v2 -> end
		long ans1 = 0;
		ans1 += dijkstar(1, v1);
		ans1 += dijkstar(v1, v2);
		ans1 += dijkstar(v2, n);
//		System.out.println(dijkstar(1, v1) + " "+dijkstar(v1, v2) + " "+dijkstar(v2, n) + " ");
		
		// start -> v2 -> v1 -> end
		long ans2 = 0;
		ans2 += dijkstar(1, v2);
		ans2 += dijkstar(v2, v1);
		ans2 += dijkstar(v1, n);
//		System.out.println(dijkstar(1, v2) + " "+dijkstar(v2, v1) + " "+dijkstar(2, n) + " ");
		
//		System.out.println(ans1 + " " + ans2);
		if(Math.min(ans1, ans2) >= INF) System.out.println(-1);
		else System.out.println(Math.min(ans1, ans2));
	}

	static int dijkstar(int start, int end) {
		PriorityQueue<path> pq = new PriorityQueue<>();
		dist = new int[n+1];
		Arrays.fill(dist, INF);
		pq.add(new path(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty()) {
			path cur = pq.poll();

			if(cur.c > dist[cur.b]) continue;
			for(path next : list[cur.b]) {
				if(dist[cur.b] + next.c < dist[next.b]) {
					dist[next.b] = dist[cur.b] + next.c;
					pq.add(new path(next.b, dist[next.b]));
				}
			}
		}
		return dist[end];
	}
}
