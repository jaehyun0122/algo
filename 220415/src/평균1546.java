import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		float[] arr = new float[n];
		st = new StringTokenizer(br.readLine());
		float max = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		float sum = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i]/max*100;
		}
		System.out.println(sum/n);
	}

}
