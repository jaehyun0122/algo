import java.util.ArrayList;
import java.util.Scanner;

public class 중복문자제거 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<Character> list = new ArrayList<>();
		char prev = 'a';
		for(int i=0; i<str.length(); i++) {
			if(str.indexOf(str.charAt(i))==i) list.add(str.charAt(i));
		}
		for(char a : list) {
			System.out.print(a);
		}
	}

}
