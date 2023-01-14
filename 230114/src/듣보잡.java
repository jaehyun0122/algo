import java.util.*;
import java.io.*;

public class µË∫∏¿‚ {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n+m; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		ArrayList<String> list = new ArrayList<>();
		
		map.forEach((key, value)->{
			if(value >= 2) list.add(key);
		});
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()+"\n");
		
		System.out.println(sb);
	}
	

}
