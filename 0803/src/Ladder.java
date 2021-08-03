import java.util.Scanner;

public class Ladder {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int[][] arr = new int[100][100];
			int cnt = sc.nextInt();
			int row = 0;
			int col = 0;
			//0,1 입력
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 2) {
						row = i;
						col = j;
					}
				}
			}
			
			while(row != 0) {
					
					//왼
					if(col-1 > -1 && arr[row][col-1] == 1) {
						arr[row][col] = 2;
						col--;
					}
					//오
					else if(col+1 < 100 && arr[row][col+1] == 1) {
						arr[row][col] = 2;
						col++;
					}
					
					else if(row-1 > -1 && arr[row-1][col] == 1){
						arr[row][col] = 2;
						row--;
					}
			}
			System.out.print("#" + cnt + " " + col);
			System.out.println();
		}
	}

}
