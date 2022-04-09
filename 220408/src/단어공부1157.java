import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부1157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int len = str.length();
		String[][] arr = new String[str.length()][2];
		int max = 0;
		int num = 0;
		while(true) {
			if(str.length()==0) break;
			char c = str.charAt(0);
			int cnt = 0;
			for(int i=0; i<str.length(); i++) {
				if(c == str.charAt(i)) {
					cnt++;
				}
			}
			if(cnt >= max) {
				arr[num][0] = Character.toString(c);
				arr[num][1] = Integer.toString(cnt);
//				System.out.println(c+" "+cnt);
				max = cnt;
				num++;
			}
			str = str.replace(Character.toString(c), "");
		}
		num = 0;
		int res = 0;
		String ans = "?";
		out:for(int i=0; i<len; i++) {
			for(int j=0; j<1; j++) {
				if(arr[i][0] == null) continue;
				if(Integer.parseInt(arr[i][1]) == max) {
					num++;
					res = i;
					if(num >=2) break out;
				}
			}
		}
		ans = num>=2? "?":arr[res][0];
		System.out.println(ans);
	}

}
