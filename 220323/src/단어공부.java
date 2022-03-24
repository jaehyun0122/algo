import java.util.Arrays;
import java.util.Scanner;

public class 단어공부 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		
		int[] arr = new int[str.length()];
		for(int i=0; i<str.length(); i++) {
			char a = str.charAt(i);
			if(str.charAt(i) != 1) {
				for(int j=i+1; j<str.length(); j++) {
					if(a == str.charAt(j)) {
						arr[i]++;
						str.replaceAll("[a-zA-z]", "");
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(str);
	}

}
