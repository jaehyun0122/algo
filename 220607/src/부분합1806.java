import java.util.*;
import java.io.*;

public class ºÎºÐÇÕ1806 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sol(arr, s, n));
	}

	static int sol(int[] arr, int s, int n) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int len = 100001;
		
		while(end <= n) {
			
			if(sum >= s) {
				sum -= arr[start];
				start++;
//				System.out.println("start : "+start+" end : "+end);
				len = Math.min(len, end-start+1);
			}
			else {
				sum += arr[end];
				end++;
			}
		}
		
		if(len == 100001) return 0;
		else return len;
	}
	
}
