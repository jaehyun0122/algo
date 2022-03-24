import java.util.*;

public class 암호 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String s = sc.next();

		String[] arr = new String[num];
		int cnt = 0;
		for(int i=0; i<s.length(); i+=7) {
			arr[cnt] = s.substring(i, i+7);
			cnt++;
		}
		
		int[][] binary = new int[num][arr[0].length()];

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<7; j++) {
				if('#' == arr[i].charAt(j) ) binary[i][j] = 1; 
				else binary[i][j] = 0;
			}
		}
		
		int[] res = new int[num];
		
		for(int i=0; i<binary.length; i++) {
			int ten = 0;
			for(int j=6; j>=0; j--) {
				if(binary[i][j] == 1) ten += Math.pow(2, 6-j); 
			}
			res[i]=ten;
			System.out.print((char) ten);
		}
	}

}
