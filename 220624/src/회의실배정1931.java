import java.util.*;
import java.io.*;

public class 회의실배정1931 {

	static class Time implements Comparable<Time>{
		int start, end;
		
		public Time (int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if(this.end == o.end) return this.start -o.start;
			else return this.end-o.end;
		}
		
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		List<Time> list = new ArrayList<>();
		
		for(int i=0; i<TC; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list.add(new Time(n,m));
		}
		Collections.sort(list);
		
		int prevTime = 0;
		int cnt = 0;
		for(int i=0; i<list.size(); i++) {
			Time cur = list.get(i);
			if(prevTime <= cur.start) {
				cnt++;
				prevTime = cur.end;
			}
		}
		
		System.out.println(cnt);
	}

}
