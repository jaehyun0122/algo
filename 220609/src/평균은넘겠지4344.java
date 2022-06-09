import java.util.*;
import java.io.*;

public class 평균은넘겠지4344 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[num];
			int total = 0;
			for(int i=0; i<num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total += arr[i];
			}
			sol(arr, total);
		}
	}

	static void sol(int[] arr, int total) {
		
		double t = total / arr.length;
		double cnt = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > t) cnt++;
		}
		double a = cnt*100/arr.length;
//		System.out.println(a);
		System.out.println(String.format("%.3f%%", a));
	}
}
