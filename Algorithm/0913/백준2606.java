package solution0913;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준2606 {

	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int cnt;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 컴퓨터의 수
		int n = sc.nextInt();
		// 간선의 수
		int m = sc.nextInt();
		list = new ArrayList[n+1];
		// arraylist초기화
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 노드간 연결데이터를 입력
		for(int i=1; i<=m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		// 
		// 방문 상태를 확인할 배열
		check = new boolean[n+1];
		cnt = 0;
		bfs(1);
		System.out.println(cnt);
	}

	static void bfs(int n) {
		// 방문 한 노드이면 함수 종료
		if(check[n]) return;
		// 방문체크를 해주고 카운트를 센다.
		check[n] = true;
		
		// 각 노드 별로 연결된 노드들을 탐색.
		for(int y : list[n]) {
			if(!check[y]) {
				bfs(y);
				cnt++;
			}
		}
	}
}
