import java.util.Scanner;

public class 문자찾기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		char ch = sc.next().toUpperCase().charAt(0);
		
		int ans = 0;
//		for(int i=0; i<str.length(); i++) {
//			if(str.charAt(i) == ch) ans++;
//		}
		for(char a : str.toCharArray()) {
			if(a == ch) ans++;
		}
		System.out.println(ans);
	}

}
