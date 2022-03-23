import java.util.Scanner;

public class 대소문자변환 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] charArr = str.toCharArray();

		for(int i=0; i<charArr.length; i++) {
			if(charArr[i] >= 'A' && charArr[i] <= 'Z') {
				charArr[i] = (char) (charArr[i]+32);
			}else charArr[i] = (char) (charArr[i] -32);
		}
		
		
		for(char a : charArr) {
			System.out.print(a);
		}
	}

}
