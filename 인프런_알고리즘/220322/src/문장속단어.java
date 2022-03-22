import java.util.Scanner;

public class 문장속단어 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

//		String ans = "";
//		String prev = "";
//		for(int i=0; i<str.length(); i++) {
//			if(str.charAt(i) == 32 || str.length()-1 == i) {
//				if(str.length()-1 == i)	prev += str.charAt(i);
//				ans = ans.length() > prev.length() ? ans : prev;
//				prev = "";
//			}else prev += str.charAt(i);
//		}
		int len = 0;
		String ans = "";
		String[] arr = str.split(" ");
		for(String a : arr) {
			if(a.length() > len) {
				ans = a;
				len = a.length();
			}
		}
		System.out.println(ans);
	}

}
