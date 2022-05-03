import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질1697 {

	static int[] check;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n == m) System.out.println(0);
		else {
			check = new int[100001];
			sol(n, m);
		}
	}

	static void sol(int n, int m) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		check[n] = 1;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0; i<3; i++) {
				int next; 
				if(i==0) next = temp+1;
				else if(i==1) next = temp-1;
				else next = temp*2;
				
				if(next == m) {
					System.out.println(check[temp]);
					return;
				}
				
				if(next >=0 && next < check.length && check[next] == 0) {
					q.add(next);
					check[next] = check[temp]+1;
				}
			}
		}
		
		
	}
}
