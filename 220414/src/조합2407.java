import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조합2407 {

	static int[] arr;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[15][5];
		
		int cnt = 0;
		for(int i=0; i<5; i++) {
			String line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				char a = line.charAt(j);
				arr[j][cnt] = a;
//				System.out.println("j : "+j+" cnt "+cnt);
			}
			cnt++;
//			System.out.println();
		}
		
//		for(char[] a : arr) {
//			for(char b : a) {
//				System.out.print(b);
//			}
//		}
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				if(arr[i][j] != '\0') System.out.print(arr[i][j]);
			}
		}
		
	}

}
