import java.util.*;
import java.io.*;

public class Ω∫≈√10828 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for(int T=0; T< tc; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// push top size empty pop 
			String commend = st.nextToken();
			if(commend.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if(commend.equals("top")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
			}
			else if(commend.equals("size")) {
				System.out.println(stack.size());
			}
			else if(commend.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(commend.equals("pop")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			}
		}
	}

}
