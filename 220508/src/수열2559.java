import java.util.*;
import java.io.*;

public class 수열2559 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<=n-k; i++) {
			int sum = 0;
			for(int j=i; j<i+k; j++) {
				sum += arr[j];
			}
			ans = sum > ans ? sum : ans;
		}
		System.out.println(ans);
	}

}
