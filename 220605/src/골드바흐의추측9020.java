import java.util.*;
import java.io.*;

public class ∞ÒµÂπŸ»Â¿«√ﬂ√¯9020 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			sol(Integer.parseInt(br.readLine()));
		}
	}

	static void sol(int num) {
	
		int[] arr = new int[num+1];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=2; i<=num; i++) {
			if(arr[i] == 0) {
				list.add(i);
				for(int j=i+i; j<=num; j+=i) {
					arr[j] = 1;
				}
			}
		}
		
		print(list, num);
		
	}
	
	static void print(ArrayList<Integer> list, int num) {
		int a=0,b=0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<list.size(); i++) {
			int n = list.get(i);
			for(int j=0; j<list.size(); j++) {
				int m = list.get(j);
					if(n+m == num) {
						if(Math.abs(n-m) < min) {
							a=n;
							b=m;
							min = Math.abs(n-m);
						}
					}
			}
		}
		System.out.println(a+" "+b);
	}
	
}
