import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea서로소집합 {

	static int[] arr;
	static int n,m;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int tc=1; tc<=T; tc++) {
			// m개의 연산
			m = Integer.parseInt(st.nextToken());
			// n이하의 자연수
			n = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			
			make_set();
			System.out.print("#"+tc+" ");
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int z = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// z가 0이 아니라면
				if(z != 0) {
					if(find_set(a) == find_set(b)) System.out.print("1");
					else System.out.print("0");
				}
				// 합집합
				else union(a,b);
			}
			System.out.println();
		}
	}

	static void make_set() {
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
	}
	
	static int find_set(int a) {
		if(arr[a] == a) return a;
		
		arr[a] = find_set(arr[a]);
		return arr[a];
	}
	
	static boolean union(int a, int b) {
		int pa = find_set(a);
		int pb = find_set(b);
		
		if(pa == pb) return false;
		
		arr[pb] = pa;
		return true;
	}
}
