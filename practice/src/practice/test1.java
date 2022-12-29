package practice;
import java.util.*;

public class test1 {

	public static void main(String[] args) {
		int n = 437674;
		String[] cities = new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		
//		System.out.println(solution(n, cities));
		int k =3;
		long con = Long.parseLong(Integer.toString(n, k));
		System.out.println(con+" ");
	}

	static int solution(int cacheSize, String[] cities) {
	        int answer = 0;
	        LinkedList<String> list = new LinkedList<>();
	        
	        if(cacheSize == 0) return cities.length*5;
	        
	        for(int i=0; i<cities.length; i++){
	            cities[i] = cities[i].toLowerCase();
	        }
	        
	        for(String str : cities){
	        	// hit
	            if(list.contains(str)) {
	            	answer += 1;
	            	list.remove(str);
	            	list.addLast(str);
		            if(list.size() > cacheSize) list.removeFirst();
		            continue;
	            }
	            
	            list.addLast(str);
	            if(list.size() > cacheSize) list.removeFirst();
	            answer += 5;
	            
	        }
	        
	        
	        return answer;
	    }
	
	
}
