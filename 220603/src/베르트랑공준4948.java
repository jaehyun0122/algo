import java.util.*;
import java.io.*;

public class 베르트랑공준4948 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) break;
			int cnt = 0;
			
			for(int i=num+1; i<=2*num; i++) {
				if(isPrime(i)) cnt++; 
			}
			System.out.println(cnt);
		}
	}

	static boolean isPrime(int n) {
		if(n == 1) return false;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}
