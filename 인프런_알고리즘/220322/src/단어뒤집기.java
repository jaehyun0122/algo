import java.util.Scanner;

public class 단어뒤집기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			String str = sc.next();
//			char[] arr = new char[str.length()];
//			
//			for(int i=0; i<str.length(); i++) {
//				arr[(Math.abs(i-str.length()))-1] = str.charAt(i);
//			}
//			for(char ans : arr) {
//				System.out.print(ans);
//			}
//			System.out.println();
			
			String res = new StringBuilder(str).reverse().toString();
			System.out.println(res);
		}
	}

}
