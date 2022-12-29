import java.util.*;
import java.util.regex.Pattern;
public class test {

	public static void main(String[] args) {

		
		
			solution("one4seveneight");
		
	}
	
    static String[] arr = {
            "zero","one","two","three","four","five",
            "six","seven","eight","nine"
        };
    
	static ArrayList<String> list = new ArrayList<>();
	
    static int solution(String s) {
        int answer = 0;
        
        String tmp = "";
        for(int i=0; i<s.length(); i++){
            if(!Pattern.matches("^[0-9]*$",Character.toString(s.charAt(i)))){
                tmp += s.charAt(i);
            } 
            if(Pattern.matches("^[0-9]*$",Character.toString(s.charAt(i))) && tmp.length()>0) {
            	list.add(tmp);
            	tmp = "";
            }
        }
        
        System.out.println(list.toString());
        
        for(int i=0; i<list.size(); i++) {
        	int res = sol(list.get(i));
        	s = s.replace(list.get(i), String.valueOf(res));
        }
        
        System.out.println(s);
        
        return 0;
    }
	
    static int sol(String str){
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(str)) return i;
        }
        return 0;
    }   

}
