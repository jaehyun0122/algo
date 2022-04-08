import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 나이순정렬10814 {
	
	static class Person implements Comparable<Person>{
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return this.age+" "+this.name;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Person p = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
			list.add(p);
		}
		Collections.sort(list);
		for(Person a : list) System.out.println(a.toString());

	}

}
