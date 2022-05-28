import java.util.*;
import java.io.*;

public class 인간컴퓨터상호작용16139 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		long n = Integer.parseInt(br.readLine());
		
		for(long i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			char tmp = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			String compare = str.substring(start, end+1);
			System.out.println(sol(start, end, tmp, compare));
		}
		
	}

	static long sol(int s, int e, char ch, String str) {
		long cnt = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ch) cnt++;
		}
		
		return cnt;
		
	}
}
