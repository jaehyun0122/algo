import java.util.Scanner;

public class 덩치7568 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt(); // 키
			arr[i][1] = sc.nextInt(); // 몸무게
		}
		
		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(int j=0; j<n; j++) {
				// 자기와 비교하는건 제외
				if(i == j) continue;
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) ++cnt;
			}
			System.out.print(cnt+" ");
		}
        System.out.println();
	}

}