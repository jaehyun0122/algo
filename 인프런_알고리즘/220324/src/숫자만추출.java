import java.util.ArrayList;
import java.util.Scanner;

public class 숫자만추출 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<Character> list = new ArrayList<>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>= '0' && str.charAt(i) <= '9') {
				list.add(str.charAt(i));
			}
		}
		String ans = "";
		for(int i=0; i<list.size(); i++) {
			ans+=list.get(i);
		}
		System.out.println(Integer.parseInt(ans));
	}
}
