import java.io.*;
import java.util.*;

public class ¿œ∞ˆ≥≠¿Ô¿Ã3040 {

	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		
		arr = new int[9];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] sumArr = new int[7];
	
		com(0, 0, sumArr);
	}
	
	static void com(int cnt, int start, int[] sumArr) {
		
		if(cnt == 7) {
			int sum = 0;
			for(int data : sumArr) {
				sum += data;
			}
			if(sum == 100) {
				for(int data : sumArr) {
					System.out.println(data);
				}
				return;
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			sumArr[cnt] = arr[i];
			com(cnt+1, i+1, sumArr);
		}
		
		
	}
	
	
}
