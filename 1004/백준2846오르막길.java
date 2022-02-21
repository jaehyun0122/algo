import java.util.Scanner;

public class 백준2846오르막길 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int max = 0;
		for(int i=0; i<n-1; i++) {
			if(arr[i] < arr[i+1]) sum+= arr[i+1] - arr[i];
			if(arr[i] >= arr[i+1] || i == n-2) {
				max = Math.max(max, sum);
				sum = 0;
			}
		}
		if(max == 0) System.out.println(0);
		else System.out.println(max);
	}

}
