import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 암호생성기 {

	public static void main(String[] args) {


		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++ ) {
			int T = sc.nextInt();
			int b_num = 0;
			
			for(int i=0; i<8; i++) {
				q.offer(sc.nextInt());
			}
		
			out:while(true) {

				for(int i=1; i<=5; i++) {
					b_num = q.poll();
					if(b_num-i <= 0) {
						q.offer(0);
						break out;
					}
					q.offer(b_num-i);
				}
				
			}

			System.out.print("#" + T + " ");
			for(int i=0; i<8; i++) {
				System.out.print( q.poll()+" ");
			}
		}
			
		
	}

}
