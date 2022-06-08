import java.util.*;
import java.io.*;

public class 소수의연속합1644 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		
		int[] prime = sol1(arr, n);
		
		sol2(prime, n);
	}

	static int[] sol1(int[] arr, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] res;
		for(int i=2; i<=n; i++) {
			if(arr[i] == 0) {
				list.add(i);
				for(int j=i+i; j<=n; j += i) {
					arr[j] = 1;
				}
			}
		}
		res = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			res[i] = list.get(i);
//			System.out.println(res[i]);
		}
//		System.out.println("============");
		return res;
	}
	
	static void sol2(int[] prime, int n) {
		int start = 0, end = 0, sum = 0, cnt = 0;
		
		while(true) {
			if(sum >=n) {
				sum -= prime[start];
				start++;
			}else if(end == prime.length) break;
			else {
				sum += prime[end];
				end++;
			}
			if(n==sum) cnt++;
		}
		System.out.println(cnt);
	}
}
