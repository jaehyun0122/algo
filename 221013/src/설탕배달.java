import java.io.InputStreamReader;
import java.io.*;


public class º≥≈¡πË¥ﬁ {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(true) {
			if(N % 5 ==  0) {
				ans += N/5;
				break;
			}
			if(N-3 == 0) {
				ans++; break;
			}
			
			if(N - 3 < 3) {
				ans = -1;
				break;
			}
			
			N -= 3;
			ans++;
			
		}
		
		System.out.println(ans);
		
	}

}
