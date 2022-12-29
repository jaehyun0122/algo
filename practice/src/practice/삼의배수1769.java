package practice;
import java.util.*;
import java.io.*;

public class »ïÀÇ¹è¼ö1769 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		cnt = 0;
		
		sol(num);
	}
	
	static int cnt;
	
	static void sol(String num) {
		
		if(num.length() == 1) {
			System.out.println(cnt);
			if(Integer.parseInt(num) % 3 == 0) System.out.println("YES");
			else System.out.println("NO");
			return;
		}
		
		String tmp = trans(num);
		
		sol(tmp);
		
		
	}
	
	static String trans(String a) {
		int res = 0;
		cnt++;
		
		for(int i=0; i<a.length(); i++) {
			res += a.charAt(i) - '0';
		}
		return String.valueOf(res);
	}

}
