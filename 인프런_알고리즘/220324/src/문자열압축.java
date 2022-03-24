import java.util.*;
public class 문자열압축 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		ArrayList<Character> list = new ArrayList<>();
		int[] arr = new int[s.length()];
		
		int cnt = 1;
		char prev = '0';
		
		for(int i=0; i<s.length(); i++) {
			cnt = 1;
			if(s.charAt(i) == prev) {
				arr[i] = -1;
				continue;
			}
			for(int j=i+1; j<s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) cnt++;
				else break;
			}
			if(cnt > 1) {
				arr[i] = cnt;
			}
			prev = s.charAt(i);
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				list.add(s.charAt(i));
				list.add((char) (arr[i]+'0'));
			}else if(arr[i]==0) list.add(s.charAt(i));
		}
		for(char a : list) System.out.print(a);
	}

}
