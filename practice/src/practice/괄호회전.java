package practice;
import java.util.*;
public class ��ȣȸ�� {
//	()(
//			(
//			{{{{{{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()[{}]";
		System.out.println(solution(s));
//		System.out.println(check(s));
	}
	static  public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            if(i != 0) s = convert(s);
             System.out.println(s);
            if(check(s)) {
                answer++;
            }
        }
        
        return answer;
    }
	
    static Character[] open = {'[', '(', '{'};
    static Character[] close = {']', ')', '}'};
    
    static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char tmp = str.charAt(i);
            // open�̸� stack�� push
            if(Arrays.asList(open).contains(tmp)){
                stack.push(tmp);
                // System.out.println("open "+tmp);
            }else{ // close�̸� 1. ù �ε����� false 2. �����̶� ¦Ȯ��
                // System.out.println("close "+tmp);
                if(i == 0 || stack.size() == 0) return false;
                if(Arrays.asList(close).contains(stack.peek())) return false;
                if(Arrays.asList(open).indexOf(stack.peek())
                   == Arrays.asList(close).indexOf(tmp)) {
                    stack.pop();
                }else return false;
            }
        }
        return true;
        
    }
    
    static String convert(String str){
        String result = "";
        char first = str.charAt(0);
        
        result = str.substring(1)+Character.toString(first);
        
        return result;
    }

}
