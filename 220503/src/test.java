import java.util.Arrays;
import java.util.Scanner;

public class test {

	static int[] input;
	static int[] numbers;
	static int[] number;
	static boolean[] check;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		input = new int[n];
		numbers = new int[r];
		number = new int[r];
		check = new boolean[n];
		
		for(int i=0; i<n; i++) {
			input[i] = sc.nextInt();
		}
		
		per(0,0,n,r);
		System.out.println("=======================");
		com(0, r, n);
	}
	
	static void per(int cnt, int start, int n, int r) {
		if(cnt == r) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<n; i++) {
			numbers[cnt] = input[i];
			per(cnt+1, i+1, n, r);
//			per(cnt+1, i, n, r);
		}
	}
	
	static void com(int cnt, int r, int n) {
		if(cnt == r) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(check[i]) continue;
//			check[i] = true;
			number[cnt] = input[i];
			
			com(cnt+1,n , r);
			
//			check[i] = false;
		}
	}

}
