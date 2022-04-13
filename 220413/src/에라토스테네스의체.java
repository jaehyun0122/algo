import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {

	static int[] arr;
	static int cnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		System.out.println(sol(n,k));
	}
	
	static int sol(int n, int k) {
		
		for(int i=2; i<=n; i++) {
			if(arr[i] == 0) {
				for(int j=i;j<=n;j=j+i) {
					if(arr[j] != 0) continue;
					cnt++;
					arr[j] = 1;
					if(cnt == k) return j;
				}
			}
		}
		return 0;
	}

}
