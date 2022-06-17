import java.util.*;
import java.io.*;

public class ³À»ö¹®Á¦1450 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sol(arr, n, c);
	}

	static void sol(int[] arr, int n, int c) {
		int start=0, end=0, sum=0, cnt=1;
		
		Arrays.sort(arr);
		
		while(true) {
			if(end==arr.length) break;
			if(sum>=c) {
				sum -= arr[start];
				start++;
			}else {
				sum += arr[end];
				end++;
			}
			if(sum<=c) {
				for(int i=start; i<end; i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println("========");
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
