import java.util.Scanner;


public class 두개의숫자열 {

	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			int test = sc.nextInt();
			
			for(int t = 1; t <= test; t++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int[] a1 = new int[n1];
				int[] a2 = new int[n2];
				int max = 0;
				
				for(int i = 0; i < n1; i++) {
					a1[i] = sc.nextInt();
				}
				
				for(int i = 0; i < n2; i++) {
					a2[i] = sc.nextInt();
				}
				
				if(n1 > n2) {
					for(int i = 0; i < n1 - n2 + 1; i++) {
						int sum = 0;
						for(int j = 0; j < n2; j++) {
							sum += a2[j] * a1[i+j];
						}
						max = Math.max(sum, max);
					}
				}
				else {
					for(int i = 0; i < n2 - n1 + 1; i++) {
						int sum = 0;
						for(int j = 0; j < n1; j++) {
							sum += a1[j] * a2[i+j];
						}
						max = Math.max(sum, max);
					}
				}
				System.out.println("#" + t + " " + max);
			}
		}
}
	
