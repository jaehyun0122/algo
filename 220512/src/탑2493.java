import java.util.*;
import java.io.*;

public class 탑2493 {

	static class Top{
		int h;
		int idx;
		
		public Top(int idx, int h) {
			this.h = h;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long n = Integer.parseInt(br.readLine());
		
		Stack<Top> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			int height = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				sb.append(0+" ");
				stack.push(new Top(i, height));
			} else{
				while(true) {
					if(stack.isEmpty()) {
						sb.append(0+" ");
						stack.push(new Top(i, height));
						break;
					}
					
					Top prevTop = stack.peek();
					
					if(prevTop.h > height) {
						sb.append(prevTop.idx+" ");
						stack.push(new Top(i, height));
						break;
					} else stack.pop();
				}
			}
		}
		System.out.println(sb);
	}

}
