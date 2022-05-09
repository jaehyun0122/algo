import java.util.*;
import java.io.*;

public class 최대힙11279 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(br.readLine());
			if(k == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			} else {
				pq.add(k);
			}
		}
	}

}
