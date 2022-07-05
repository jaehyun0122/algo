import java.util.*;

public class 단체사진찍기 {

	public static void main(String[] args) {
		String[] arr = {"N~F=0", "R~T>2"};
		System.out.println(solution(2, arr));

	}

	  static String[] cData;
	    static boolean[] check;
	    static int[] tmpArr;
	    static Map<Character, Integer> map = new HashMap<>();
	    
	    public static int solution(int n, String[] data) {
	        
	        cData = data;
	        ans = 0;
	        check = new boolean[8];
	        tmpArr = new int[8];
	        map.put('A',0);
	        map.put('C',1);
	        map.put('F',2);
	        map.put('J',3);
	        map.put('M',4);
	        map.put('N',5);
	        map.put('R',6);
	        map.put('T',7);
	        dfs(0);
	        return ans;
	    }
	    static int ans;
	    
	    static void dfs(int idx){
	        if(idx == 8){
	            if(isValid()){
	                ans++;            
	            }
	        }
	        
	        for(int i=0; i<8; i++){
	            if(!check[i]){
	                check[i] = true;
	                tmpArr[idx] = i;
	                dfs(idx+1);
	                check[i] = false;
	            }
	        }
	        
	    }
	    static String[] alpa = {"A", "C", "F", "J", "M", "N", "R", "T"};
	    
	    static boolean isValid(){
	        int a,b,pos,dist;
	        char op;
	        
	        for(String str : cData){
	        	a = tmpArr[map.get(str.charAt(0))];
	        	b = tmpArr[map.get(str.charAt(2))];
	            op = str.charAt(3);
	            pos = str.charAt(4)-'0'+1;
	            dist = Math.abs(a-b);

	            switch (op){
	                case '=':
	                    if(dist != pos) return false;
	                    break;
	                case '>':
	                    if(dist <= pos) return false;
	                    break;
	                case '<':
	                    if(dist >= pos) return false;
	                    break;
	            }
	        }
	        return true;
	        
	    }
}
