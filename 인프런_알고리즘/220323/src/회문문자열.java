import java.util.Scanner;

public class 회문문자열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		int front = 0;
		int back = str.length()-1;
		String ans = "YES";
		while(back > front) {
			if(str.charAt(front) == str.charAt(back)) {
				front += 1;
				back -= 1;
			} else {
				ans = "NO";
				break;
			}
		}
		System.out.println(ans);
	}

}
