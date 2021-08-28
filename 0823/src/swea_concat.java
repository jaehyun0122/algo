import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class swea_concat {
	
	class Node {
		int cnt;
		int num;
		
		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			// 노드의 개수
			int n = sc.nextInt();
			// 시작 노드
			int start = sc.nextInt();
			// 각 노드들이 저장될 리스트 배열
			List<Integer>[] list = new LinkedList[101];
			for(int i=1; i<=100; i++) {
				list[i] = new LinkedList<>();
			}
			// from, to가 입력되니까 i+2만 큼 증가
			for(int i=0; i<n; i+=2) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list[from].add(to);
			}
			
			
			Queue<Integer> q = new LinkedList<>();
			// 방문 체크
			boolean[] visited = new boolean[101];
			// 정답 저장할 변수
			int ans = 0;
			// 시작노드를 큐에 넣어주고 방문 배열 true
			q.add(start);
			visited[start] = true;
			// 큐가 소진 될때까지 
			while(!q.isEmpty()) {
				// 큐 사이즈만 큼 돌면서 최대값 찾기
				int size = q.size();
				ans = 0;
				for(int i=0; i<size; i++) {
					int num = q.poll();
					ans = Math.max(ans, num);
					// 리스트를 돌면서 방문지점은 패스하고
					// 방문안한 노드있으면 visited를 true로하고
					// 큐에 넣어준다.
					for(int a : list[num]) {
						if(visited[a]) continue;
						visited[a] = true;
						q.offer(a);
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

}
