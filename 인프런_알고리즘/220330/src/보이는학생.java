import java.util.*;

public class 보이는학생 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		int prev =arr[0];
		for(int i=0; i<n; i++) {
			if(i==0) cnt++;
			else if(arr[i] > prev) {
				cnt++;
				prev = arr[i];
			}
		}
		System.out.println(cnt);
	}

}
