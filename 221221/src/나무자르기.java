import java.util.*;
import java.io.*;
public class 나무자르기 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		long max = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = max < arr[i] ? arr[i] : max;
		}
		long start = 0;
		while(start <= max) {
			long mid = (start + max)/2;
			long sum = 0;
			for(int len : arr) {
				if(len > mid) sum += len-mid;
			}
			
			if(sum >= m) {
				start = mid+1;
			}else {
				max = mid-1;
			}
		}
		System.out.println(max);
		
	}

}
