import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부1157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int len = str.length();
		int[][] arr = new int[27][2];
		int max = -1;
		while(true) {
			int cnt = 0;
			if(str.length() == 0) break;
			char c = str.charAt(0);
			for(int i=0; i<str.length(); i++) {
				if(c == str.charAt(i)) {
					arr[c-'A'][0]++;
					cnt++;
				}
				if(cnt>=max) max = cnt;
			}
			str = str.replace(Character.toString(c), "");
		}
		char ans = '?';
		int num = 0;
			for(int i=0; i<27; i++) {
				if(arr[i][0]==max) {
					ans = (char)(i+'A');
					num++;
				}
				if(num > 1) {
					ans = '?';
					break;
				}
			}			
		System.out.println(ans);
	}

}
