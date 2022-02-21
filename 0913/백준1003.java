package solution0913;

import java.util.Scanner;

public class 백준1003 {

	static long[] d;
	static int zero;
	static int one;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			d = new long[100];
			int n = sc.nextInt();
			zero =0;
			one = 0;
			fibo(n);
			System.out.println(zero + " " + one);
		}
	}

	static long fibo(int n) {
		if(n == 0) {
			zero++;
			return 0;
		}
		if(n == 1) {
			one++;
			return 1;
		}
		if(d[n] != 0) return d[n];
		return d[n] = fibo(n-1) + fibo(n-2);
	}
}
