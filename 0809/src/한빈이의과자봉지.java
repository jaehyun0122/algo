import java.util.Scanner;

public class 한빈이의과자봉지 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //testcase
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //과자봉지 개수
			int M = sc.nextInt(); //제한 무게
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {  // N개의 과자 무게
				arr[i] = sc.nextInt(); 
			}
			
			int sum = 0;
			int max = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					sum = arr[i] + arr[j];
					if(sum <= M && sum > max) {
						max = sum;
					}
				}
			}
			
			if(max == 0) System.out.println("#"+tc+" "+"-1");
			else System.out.println("#"+tc+" "+max);
			
		}
	}

}
