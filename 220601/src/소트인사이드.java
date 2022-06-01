import java.util.*;
import java.io.*;

public class 소트인사이드 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String num = sc.next();
		
		char[] arr = num.toCharArray();
		
		Arrays.sort(arr);
		
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
		
		
	}

}
