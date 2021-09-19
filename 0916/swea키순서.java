import java.util.ArrayList;
import java.util.Scanner;

public class swea키순서 {

	static ArrayList<Integer>[] arr;
	static boolean[] check;
	static int[] count;
	static int temp;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			arr = new ArrayList[n+1];
			count = new int[n+1];
			for(int i=1; i<=n; i++) {
				arr[i] = new ArrayList<>();
			}
			for(int i=1; i<=m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x].add(y);
			}
			for(int i=1; i<= n; i++) {
				temp = 0;
				check = new boolean[n+1];
				dfs(i,i);
				count[i] += temp;
			}
			int ans = 0;
			for(int i=1; i<=n; i++) {
				System.out.print(count[n] + " ");
//				if(count[i] == n) ans++;
			}
//			System.out.println(ans);
		}
	}
	
	static void dfs(int now, int start) {
		temp += 1;
		for(int i=0; i<arr[now].size(); i++) {
			int next = arr[now].get(i);
			if(check[next]) continue;
			
			check[next] = true;
			count[next] += 1;
			dfs(next, start);
		}
	}

}
