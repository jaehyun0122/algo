import java.util.Scanner;

public class 특정문자뒤집기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] arr = str.toCharArray();
		boolean[] bln = new boolean[str.length()];
		
		for(int i=0; i<arr.length; i++) {
			if((Character.isAlphabetic(arr[i])) && Character.isAlphabetic(arr[Math.abs(i-str.length())-1])&&!bln[i]) {
				char temp = arr[Math.abs(i-arr.length)-1];
				bln[Math.abs(i-arr.length)-1] = true;
				arr[Math.abs(i-arr.length)-1] = arr[i];
				arr[i] = temp;
				bln[i] = true;
			}
		}
		for(char ans : arr) System.out.print(ans);
	}

}
