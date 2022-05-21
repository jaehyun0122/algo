import java.util.*;
import java.io.*;

public class 스타트와링크14889 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();

		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(q.size()>1) {
			
			for(int i=0; i<m-1; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll());
			sb.append(", ");
		}
		sb.append(q.poll());
		sb.append(">");
		System.out.println(sb);
	}
	

}
