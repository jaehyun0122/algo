import java.util.*;
import java.io.*;

public class 암호만들기1759 {

	static char[] arr;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new char[c];
		tmpArr = new char[l];
		
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken().charAt(0);
			
		}
		Arrays.sort(arr);
		sol(0,0,l);
	}
	
	static char[] tmpArr;
	
	static void sol(int x, int cnt, int l) {
		if(cnt == l) {	
			if(isUp(tmpArr)) {
				System.out.println(tmpArr);
			}
			return;
		}
		
		for(int i=x; i<arr.length; i++) {
			tmpArr[cnt] = arr[i];
			sol(i+1, cnt+1, l);
		}
	}

	static boolean isUp(char[] tmpArr) {
		int mo = 0;
		int ja = 0;
		int prev = tmpArr[0]-'0';
		
		for(char x : tmpArr) {
			if(x == 'a' || x=='e' || x=='i' || x=='o' || x=='u') mo++;
			else ja++;
			if(prev != x-'0') {
				if(prev > x-'0') return false;
				prev = x-'0';
			}
		}	
		if(mo < 1 || ja < 2) return false;
		
		return true;
	}
	
}
