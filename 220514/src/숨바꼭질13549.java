import java.util.*;
import java.io.*;

public class 숨바꼭질13549 {

	static int max = 1000000;
	static boolean[] check;
	
	static class Point implements Comparable<Point>{
		int position;
		int time;
		
		public Point(int position, int time) {
			this.position = position;
			this.time = time;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		check = new boolean[max+1];
		ans = Integer.MAX_VALUE;
		bfs(n, k);
		System.out.println(ans);
	}

	static int ans;
	
	static void bfs(int n, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(n , 0));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			check[cur.position] = true;
			
			if(cur.position == k) ans = cur.time < ans ? cur.time : ans;
			if(cur.position*2 <= max && !check[cur.position*2]) pq.offer(new Point(cur.position*2, cur.time));
			if(cur.position-1 >= 0 && !check[cur.position-1]) pq.offer(new Point(cur.position-1, cur.time+1));
			if(cur.position+1 <= max && !check[cur.position+1]) pq.offer(new Point(cur.position+1, cur.time+1));
		}
		
	}
}
