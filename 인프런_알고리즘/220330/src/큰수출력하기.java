import java.util.*;

public class 큰수출력하기 {

	public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			if(i==0) System.out.print(arr[i]+" ");
			if(i!=0 && arr[i-1] < arr[i]) System.out.print(arr[i]+" ");
		}
	}

}
