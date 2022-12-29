package practice;
import java.util.*;
import java.io.*;
public class 순열조합 {

	static int[] arr;
	static int[] permu = new int[5];
	static int[] combi = new int[5];
	public static void main(String[] args) throws IOException{

		arr = new int[]{1,5,6,7,9};
//		permutation(0);
		combination(0, 0);
	}
	
	static void combination(int start, int cnt) {
		if(cnt == 3) {
			System.out.println(Arrays.toString(combi));
			return;
		}
		for(int i=start; i<5; i++) {
			combi[cnt] = arr[i];
			combination(i+1, cnt+1);
		}
	}
	
	static boolean[] check = new boolean[5];
	static void permutation(int cnt) {
		if(cnt == 5) {
			System.out.println(Arrays.toString(permu));
		}
		
		for(int i=0; i<5; i++) {
			if(check[i]) continue;
			check[i] = true;
			permu[cnt] = arr[i];
			permutation(cnt+1);
			check[i] = false;
		}
		
		
		
	}

}
