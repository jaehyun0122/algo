import java.util.*;
import java.io.*;

public class µÎ¿ë¾×2470 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sol(arr, n);
		
	}

	static void sol(int[] arr, int n) {
		int min = Integer.MAX_VALUE;
		int start=0, end=n-1;
		int sum = 0;
		int tmp = 0;
		int num1=0, num2 = 0;
		
		Arrays.sort(arr);
		
		while(true) {
			if(start>=end) break;
			
			sum = arr[start]+arr[end];
			tmp = Math.abs(sum);
			
			if(tmp < min) {
				min = tmp;
				num1 = arr[start];
				num2 = arr[end];
				
			}
			if(sum <= 0) start++;
			else end--;
		}
		System.out.println(num1 + " "+num2);
	}
}
