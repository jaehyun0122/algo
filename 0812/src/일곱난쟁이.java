import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {

	static int[] arr;
	static int[] result;
	static boolean sel = false;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		result = new int[7];
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		select(0, 0, 0);
		
	}
	
	static void select(int idx, int cnt, int sum) {
		
		if(sel) return;
		
		if(cnt == 7) {
			if(sum == 100) {
				Arrays.sort(result);
				for(int i=0; i<7; i++) {
					System.out.println(result[i]);
				}
				
				sel = true;
			}
			return;
		}
		if(idx >= 9) return;
		
		if(sum > 100) return;
		
		
		result[cnt] = arr[idx];
		select(idx+1, cnt+1, sum+arr[idx]);
		
		select(idx+1, cnt, sum);
		
	}
	
}
