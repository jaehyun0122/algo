import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이1913 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		// 시작위치
		int x = n/2-1;
		int y = n/2-1;
		// 열증가 => 행증가 => 열감소 => 행감소
		arr[n/2][n/2] = 1;
		int cnt = 2;
		int num = 2;
		int a = n/2;
		int b = n/2;
		out:while(true) {
			for(int i=1; i<=4; i++) {
				for(int j=0; j<cnt; j++) {
					if(i == 1) y++;
					if(i == 2) x++;
					
					if(i == 3) y--;
					if(i == 4) x--;
 					arr[x][y] = num;
 					if(num == m) {
 						a = x;
 						b = y;
 					}
					num++;
					if(num == n*n+1) break out;
				} // end j
			} // end i
			cnt += 2;
			x -= 1;
			y -= 1;
		} // end while
				
		StringBuilder sb = new StringBuilder();
		for(int[] array : arr) {
			for(int value : array) sb.append(value+" ");
			sb.append("\n");
		}
		sb.append(a+1+" ");
		sb.append(b+1);
		System.out.print(sb);
	}

}
