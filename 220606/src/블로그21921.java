import java.util.*;
import java.io.*;

public class ºí·Î±×21921 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int sum = 0;
		int period = 1;
		
		for(int i=0; i<n; i++) {
			
			sum += arr[i];
			
			if(i == x-1) max = sum;
			
			if(i >= x) {
				sum -= arr[i-x];
				if(sum > max) {
					max = sum;
					period = 1;
				}else if(sum == max) {
					period++;
				}
			}
			
		}
		
		if(max == 0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(period);
		}
	}

}
