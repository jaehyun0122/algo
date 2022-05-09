import java.util.*;
import java.io.*;

public class 가운데를말해요1655 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minH = new PriorityQueue<>();
		PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			int callNum = Integer.parseInt(br.readLine());
			
			if(minH.size() == maxH.size()) {
				maxH.add(callNum);

				if(!minH.isEmpty() && minH.peek() < maxH.peek()) {
					maxH.add(minH.poll());
					minH.add(maxH.poll());
				}
			} else {
				minH.add(callNum);
				
				if(maxH.peek() > minH.peek()) {
					maxH.add(minH.poll());
					minH.add(maxH.poll());
				}
			}
			sb.append(maxH.peek()+"\n");
		}
		System.out.print(sb);
	}

}
