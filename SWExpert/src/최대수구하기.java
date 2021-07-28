
import java.util.Scanner;

public class 최대수구하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc < T; tc++) {
			int[] a = new int[10];
			int max = 0;
			for(int i = 0; i < 10; i++) {
				a[i] = sc.nextInt();
			}
			for(int j =0; j < 10;j++) {
				if(a[j]>max) {
					max = a[j];
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
}
