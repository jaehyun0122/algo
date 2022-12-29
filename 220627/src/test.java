import java.util.ArrayList;

public class test {

	public static void main(String[] args) {

		String[] arr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		solution(3, arr);
		int a = 0, b = 1;
		int[] ans = {};
		ans = new int[]{a,b};
	}

	 static void solution(int n, String[] words) {
	        
	        int turn = 0;
	        ArrayList[] list = new ArrayList[n+1];
	        
	        for(int i=1; i<=n; i++){
	            list[i] = new ArrayList<String>();
	        }
	        int num = 1;
	        for(int i=0; i<words.length; i++){
	            if(num%3 == 1){
	                turn++;    
	            }
	            if(num == 4) num = 1;
	            if(i!=0) {
	            	if(!check(list, words[i])){
	            		break;
	            	}
	            }
	            list[num].add(words[i]);
	            
	            num++;
	        }
	        int res = 0;
	        if(num%3 == 0) res = 3;
	        else if(num%3 == 1) res = 1;
	        else res = 2;
	        System.out.print(res+" "+turn);
	    }
	    
	    static boolean check(ArrayList[] list, String word){
	        for(int i=1; i<list.length; i++){
	            for(int j=0; j<list[i].size(); j++){
	                if(word.equals(list[i].get(j))) return false;
	            }
	        }
	        return true;
	    }
}
