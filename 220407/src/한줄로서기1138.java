import java.util.*;

public class 한줄로서기1138 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=n; i>=1; i--) {
			list.add(arr[i], i);
		}
		
		for(int a : list) System.out.print(a+" ");
	}

}
