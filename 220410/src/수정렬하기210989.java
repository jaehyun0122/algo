import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기210989 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for(int i=0; i<n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<10001; i++) {
			if(arr[i] != 0) {
				while(arr[i] != 0) {
					sb.append(i).append("\n"); 
					arr[i]--;
				}
			}
		}
		System.out.println(sb);
	}

}
