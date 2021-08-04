import java.util.Scanner;

public class 농장물 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];

			for (int i = 0; i < size; i++) {
				String str = sc.next();
				for (int j = 0; j < size; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			int center = size/2;
			int dist = size/2 ; //거리가 작거나 같은거 수확
			//center 까지의 합계
			int sum = 0;
			for(int i=0; i<=center; i++) {
				for(int j=center-i; j<=center+i; j++) {
					sum += arr[i][j];
				}
			}
			for(int i=center+1; i<size; i++) {
				for(int j=0; j<size; j++) {
					if (j >= i - center && j < size - (i - center)) {
						sum += arr[i][j];
					}
					
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
		
	}

}
