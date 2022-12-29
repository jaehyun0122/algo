package practice;
import java.util.*;
import java.io.*;


public class ±¹¿µ¼ö {

	static class Person implements Comparable<Person>{
		String name;
		int ko, eng, math;
		
		public Person(String name, int ko, int eng, int math) {
			this.name = name;
			this.ko = ko;
			this.eng = eng;
			this.math = math;
		}
		
		@Override
		public int compareTo(Person o) {
			if(this.ko == o.ko) {
				if(this.eng == o.eng) {
					if(this.math == o.math) {
						return name.compareTo(o.name);
					}
					return o.math - this.math;
				}
				return this.eng - o.eng;
			}
			return o.ko - this.ko;
		}

	}
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Person> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int ko = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			list.add(new Person(name, ko, eng, math));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(Person p : list) {
			sb.append(p.name).append("\n");
		}
		
		System.out.println(sb);
	}

}
