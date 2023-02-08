import java.util.*;
import java.io.*;

public class 나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			String data = br.readLine();
			map1.put(String.valueOf(i), data);
			map2.put(data, String.valueOf(i));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			if(map1.containsKey(str)) {
				sb.append(map1.get(str));
			}else {
				sb.append(map2.get(str));
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}


}
