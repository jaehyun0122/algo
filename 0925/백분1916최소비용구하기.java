import java.util.*;

public class 백분1916최소비용구하기 {
	
	static class path implements Comparable<path>{
		int v; // 정점
		int w; // 비용
		path(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(path o) {
			return this.w - o.w;
		}
	}
	static int N,M;
	static int start, end;
	static ArrayList<path>[] list;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 정점의 수
		N = sc.nextInt();
		// 연결 정보의 개수
		M = sc.nextInt();
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		// 모든 거리 무한대로.
		Arrays.fill(dist, INF);
		// 각 연결정보 입력
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// a에 연결된 b의 가중치 c
			list[a].add(new path(b,c));
		}
		// 출발지와 목적지 정보
		start = sc.nextInt();
		end = sc.nextInt();
		
		System.out.println(dijkstra());

	}
	
	static int dijkstra() {
		PriorityQueue<path> pq = new PriorityQueue<>();
		pq.add(new path(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			path cur = pq.poll();
			// 가려고하는 길이 더 크면 패스.
			if(cur.w > dist[cur.v]) continue;
			// 현재 노드에 연결된 모든 정점을 돌면서
			for(path next : list[cur.v]) {
				// 거처가는 경로가 더 빠르다면 갱신.
				if(dist[cur.v] + next.w < dist[next.v]) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.add(new path(next.v, dist[next.v]));
				}
			}
		}
		return dist[end];
	}
}
