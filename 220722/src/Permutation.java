import java.util.*;
public class Permutation {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		check = new boolean[arr.length];
		int[] perArr = new int[3];
		int[] comArr = new int[3];
		permu(arr, perArr, 3, 0);
		System.out.println("=============");
		combi(arr, comArr, 3, 0, 0);
	}

	static boolean[] check;
	static void permu(int[] arr, int[] perArr, int n, int cnt) {
		
		if(cnt == n) {
			System.out.println(Arrays.toString(perArr));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(check[i]) continue;
			perArr[cnt] = arr[i];
			check[i] = true;
			permu(arr, perArr, n, cnt+1);
			check[i] = false;
		}
		
	}
	
	static void combi(int[] arr, int[] comArr, int n, int cnt,int start) {
		if(cnt == n) {
			System.out.println(Arrays.toString(comArr));
			return;
		}
		
		for(int i = start; i<arr.length; i++) {
			comArr[cnt] = arr[i];
			combi(arr, comArr, n, cnt+1, i);
		}
		
		
	}
	
	
}
