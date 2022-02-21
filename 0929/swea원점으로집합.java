import java.util.Scanner;

public class swea원점으로집합 {

	static int[] point;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			int n = sc.nextInt();
			point = new int[n];
			int max = 0;
			
			for(int i=0; i<n; i++) {
				// 음수가 필요없으므로 절대값으로 더해준다.
				point[i] = Math.abs(sc.nextInt()) + Math.abs(sc.nextInt());
				max = Math.max(max, point[i]);
			}
			System.out.println("#" + tc + " " + solv(max, n));
		}
	}

	static int solv(int max, int n) {
		// 홀짝 확인. 첫번째 원소를 대상.
		for(int i=1; i<n; i++) {
			// 홀짝이 같으면 패스
			if(point[0]%2 == point[i]%2) continue;
			// 홀짝이 다르면 원점에 도달할 수 없음.
			else return -1;
		}
		
		int sum = 0;
		int cnt = 0;
		while(true) {
			if(point[0]%2 == sum%2 && max <= sum) break;
			
			cnt++;
			sum += cnt;
		}
		return cnt;
	}
	
}
