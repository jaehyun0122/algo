import java.util.*;

public class 백준1181단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];
		for(int i=0; i<n; i++) {
			str[i] = sc.next();
		}
		
		Arrays.sort(str);
		
		// 삽입정렬
		for(int i=1; i<n; i++) {
			// 비교대상의 idx
			int j = i-1;
			// 비교대상 문자열
			String string = str[i];
			while(j >= 0 && string.length() < str[j].length()) {
				str[j+1] = str[j];
				j--;
			}
			str[j+1] = string;
		}
		
		
		for(int i=0; i<str.length; i++) {
			if(i+1<str.length && str[i].equals(str[i+1])) continue;
			System.out.println(str[i]);
		}
	}
}
