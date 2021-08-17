import java.util.Scanner;

public class Z {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int size = (int) Math.pow(2, n);
		
		search(r, c, size);
		System.out.println(cnt);
	}
	
	static int cnt=0;
	
	static void search(int r, int c, int size) {
		
		// 변의 길이가 1이면 끝
		if(size == 1) return;
		
		// 2사분변
		if( r < size/2 && c < size/2) {
			search(r, c, size/2 );
		}
		// 1사분면
		else if( r < size/2 && c >= size/2) {
			cnt += (size*size)/4;
			search(r, c-size/2, size/2);
		}
		// 3사분면
		else if( r >= size/2 && c < size/2) {
			cnt += ((size*size)/4)*2;
			search(r-size/2, c, size/2);
		}
		// 4사분면
		else {
			cnt += ((size*size)/4)*3;
			search(r-size/2, c-size/2, size/2);
		}
		
	}
	

}
