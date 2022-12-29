package practice;
import java.util.*;

public class 사전과제 {

	public static void main(String[] args) {
		
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(1);
		s.add(2);
		s.add(4);
		
		for(Integer a : s) {
			System.out.println(a);
		}
		System.out.println("====");
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
		set.add(1);
		set.add(1);
		set.add(2);
		set.add(4);
		set.add(100);
		set.add(200);
		set.add(3);
		
		for(Integer a : set) {
			System.out.println(a);
		}
	}

}
