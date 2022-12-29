import java.util.*;
import java.io.*;

public class ´õ¸Ê°Ô {

	public static void main(String[] args) {
		
		Queue<Long> q = new PriorityQueue<>();
		

		
		System.out.println("q size() "+q.size());
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		System.out.println("q size() "+q.size());
	}

}
