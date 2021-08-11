import java.util.Scanner;

public class 백준_도형이가만든맛있는음식 {

	static int[] s_arr;
	static int[] b_arr;
	static int N;
	static int min;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		s_arr = new int[N];
		b_arr = new int[N];
		// 음식 개수 만큼 신맛 쓴맛 입력
		for(int i=0; i<N; i++) {
			s_arr[i] = sc.nextInt();
			b_arr[i] = sc.nextInt();
		}
		min = 1000000000;
		taste(0, 1, 0);
		System.out.println(min);
		
		
	}
	
	
	static void taste(int idx, int s, int b) {
		if( idx == N ) {
			if(s == 1) return;
			
			if(min > Math.abs(s-b)) {
				min = Math.abs(s-b);
			}
			return;
			
		}
		
		taste(idx+1, s*s_arr[idx], b+b_arr[idx]);
		
		taste(idx+1, s, b);
	}

}
