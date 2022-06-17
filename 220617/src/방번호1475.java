import java.util.*;
import java.io.*;


public class ¹æ¹øÈ£1475 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num = st.nextToken();
		
		System.out.println(sol(num));
	}
	
	static int sol(String num) {
		int cnt = 0;
		int[] check = new int[10];
		for(int i=0; i<num.length(); i++) {
			if(num.charAt(i)-'0' == 9 || num.charAt(i)-'0' == 6) {
				if(check[6] > check[9]) check[9]++;
				else check[6]++;
			}
			else check[num.charAt(i)-'0']++;
		}
		Arrays.sort(check);
//		for(int a : check) System.out.println(a);
		return check[9];
	}
}
