import java.util.*;
import java.io.*;

public class 절대값힙11286 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						int o1Abs = Math.abs(o1);
						int o2Abs = Math.abs(o2);
						
						if(o1Abs>o2Abs) return 1;
						else if(o1Abs == o2Abs) return o1-o2;
						else return -1;
					}
				}
				);
		
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
