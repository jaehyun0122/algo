import java.util.Arrays;
import java.util.Scanner;

public class 숫자를정렬하자 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int[] a = new int[N];
			for(int i=0; i<N; i++) {
				a[i] = sc.nextInt();			
				}
			
			System.out.print("#"+(tc+1)+" ");
			Arrays.sort(a);
			for(int j=0; j<N; j++) {
				System.out.print(a[j]+" ");
			}
			System.out.println();
		}
	}

}
