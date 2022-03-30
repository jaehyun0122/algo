import java.util.*;

public class 피보나치수열 {

	static int n;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[101];
		for(int i=1; i<=n; i++) {
			System.out.print(fibo(i)+" ");
		}
	}

	public static int fibo(int n) {
		if(n <= 1) return n;
		else if(arr[n] != 0) return arr[n];
		else return arr[n] = fibo(n-2) + fibo(n-1);
	}
}
