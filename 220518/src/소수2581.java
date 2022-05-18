import java.util.*;
import java.io.*;

public class 소수2581 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		check = new boolean[n+1];
		isPrime();
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=m; i<=n; i++) {
			if(!check[i]) {
				sum += i;
				if(min == Integer.MAX_VALUE) min = i;
			}
		}
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		}else System.out.println(-1);
	}
	static boolean[] check;
	static boolean sol(int num) {
		for(int j=2; j<= Math.sqrt(num); j++) {
			if(num % j == 0) return false; 
		}
		return true;
	}
	
	public static void isPrime() {
		check[0] = true;
		check[1] = true;
		
		for(int i = 2; i <= Math.sqrt(check.length); i++) {
			for(int j = i * i; j < check.length; j += i) {
				check[j] = true;
			}
		}
		
	}
}
