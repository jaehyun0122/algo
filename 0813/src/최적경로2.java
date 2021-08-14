import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최적경로2 {
	// x , y 좌표를 받을 point class 생성.
	static class Point {
		int x, y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static List<Point> list;
	static Point start, dest;
	static int N, ans;
	static boolean[] sel;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 좌표를 저장할 리스트
		for(int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			sel = new boolean[N];
			// 출발지와 목적지를 제외한 중간 좌표 입력
			list = new ArrayList<>();
			// 출발지와 목적지 좌표먼저 입력받는다.
			start = new Point(sc.nextInt(), sc.nextInt());
			dest = new Point(sc.nextInt(), sc.nextInt());
			
			// N개의 수 만큼 list.add
			for(int i=0; i<N; i++) {
				list.add(new Point(sc.nextInt(), sc.nextInt()));
			}
			ans = Integer.MAX_VALUE;
			perm(0, 0, start);
			System.out.println("#" + tc + " "+ans);
		}
		
	}
	// 
	public static void perm(int cnt, int dist, Point p) {
		// 계산한 dist가 이전의 최소값인 ans보다 크면 비교할 필요없이 return
		if(dist > ans) return;
		
		if(cnt == N) {
			dist += Math.abs(p.x - dest.x) + Math.abs(p.y - dest.y);
			ans = Math.min(ans, dist);
			return;
		}
		
		for(int i=0; i<N; i++) {
			// i번째 수가 사용중이면 패스
			if(sel[i]) continue;
			// 사용중이 아니면 T로 바꾸고 다음수
			sel[i] = true;
			// list i번째가 start로 바뀌면서 비교
			perm(cnt+1,dist+Math.abs(p.x - list.get(i).x)+Math.abs(p.y - list.get(i).y), list.get(i));
			sel[i] = false;
		}
		
	}

}
