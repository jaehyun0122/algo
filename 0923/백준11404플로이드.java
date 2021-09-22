import java.util.Arrays;
import java.util.Scanner;

public class 백준11404플로이드 {

	public static final int INF = (int)1e9; // 무한을 의미하는 값
	// 도시의 개수와 버스의 개수
	static int n,m;
	static int[][] bus;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		bus = new int[n+1][n+1];
		// 모든 버스의 비용을 INF로 채워준다.
		for(int i=1; i<=n; i++) {
			Arrays.fill(bus[i], INF);
		}
		// 출발지와 도착지가 같으면 0으로 채워준다.
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j) bus[i][j] = 0;
			}
		}
		// 각 간선에 대한 정보를 입력
		// 출발지와 도착지 정보가 하나 이상일 수 있으니 최소비용을 비교해서 저장한다.
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			bus[a][b] = Math.min(c, bus[a][b]);
		}
		System.out.println();
		// 플로이드 워셜 알고리즘 수행.
		// k : 경유지 a : 출발지 b : 도착지.
		for(int k=1; k<=n; k++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					if(a == b) continue;
					// a~b와 a~k~b를 비교해 최소값을 찾는다.
					bus[a][b] = Math.min(bus[a][b], bus[a][k] + bus[k][b]);
				}
			}
		}
		// 최소 비용을 출력. 갈수없으면 0
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(bus[i][j] == INF) System.out.print(0+" ");
				else System.out.print(bus[i][j]+" ");
			}
			System.out.println();
		}
	}

}
