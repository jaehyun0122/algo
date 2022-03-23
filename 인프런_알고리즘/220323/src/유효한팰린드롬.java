import java.util.Scanner;

public class 유효한팰린드롬 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		str = str.replaceAll("[^A-Za-z]", "");
		
		String rev = new StringBuilder(str).reverse().toString();
		String ans = "YES";
		
		for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) != rev.charAt(i)) {
					ans = "NO";
					break;
				}
		}
		
		
		System.out.println(ans);
	}

}
