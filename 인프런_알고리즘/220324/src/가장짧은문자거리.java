import java.util.*;

public class 가장짧은문자거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char t = sc.next().charAt(0);
//		ArrayList<Integer> list = new ArrayList<>();
		int[] ans = new int[s.length()];
//		Arrays.fill(ans, 101);
//		for(int i=0; i<s.length(); i++) {
//			if(s.charAt(i) == t) list.add(i);
//		}
//		
//		for(int i=0; i<s.length(); i++) {
//			if(s.charAt(i)==t) ans[i]=0;
//			else {
//				for(int j=0; j<list.size(); j++) {
//					ans[i] = ans[i]<Math.abs(list.get(j)-i)? ans[i] : Math.abs(list.get(j)-i);
//				}
//			}
//		}
//		for(int a : ans) System.out.print(a+" ");
		int tmp = 100;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == t) {
				tmp = 0;
				ans[i] = tmp;
			}else {
				tmp++;
				ans[i] = tmp;
			}
		}
		tmp = 100;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i) == t) {
				tmp = 0;
				ans[i] = tmp;
			}else {
				tmp++;
				ans[i] = ans[i]<tmp?ans[i]:tmp;
			}
		}
		for(int a : ans) System.out.print(a+" ");
	}
}
