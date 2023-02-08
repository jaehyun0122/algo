import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class 파일정리 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String data = br.readLine();
			int dot = data.indexOf(".");
			String extension = data.substring(dot+1);
			
			map.put(extension, map.getOrDefault(extension, 0)+1);
		}
		
		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str+" ").append(map.get(str)).append("\n");
		}
		
		System.out.println(sb);
	}

}
