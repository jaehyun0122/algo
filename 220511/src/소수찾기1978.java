import java.util.*;
import java.io.*;

public class 소수찾기1978 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if(isPrime(num)==1) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	static int isPrime(int num) {
		
		if(num == 1) return 0;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) return 0;
		}
		return 1;
	}
}
