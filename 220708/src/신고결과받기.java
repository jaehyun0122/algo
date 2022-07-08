import java.util.*;
import java.io.*;

public class 신고결과받기 {

	public static void main(String[] args) {

		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		list = new ArrayList<>();
		System.out.println(Arrays.toString((solution(id_list, report, 2))));
	}
	
	
        
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        list = new ArrayList<>();
        StringTokenizer st;
        countArr = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++){
            idMap.put(id_list[i], i);
            list.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<report.length; i++){
            st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            
            boolean check = false;
            
            if(list.get(idMap.get(from)).size() > 0){
                for(int j=0; j<list.get(idMap.get(from)).size(); j++){
                    if(list.get(idMap.get(from)).get(j) == idMap.get(to)){
                        check = true;
                    } 
                }
            }
            
            if(!check){
                countArr[idMap.get(to)]++;
                list.get(idMap.get(from)).add(idMap.get(to));         
            }
            
            
        }
        
        sol(k, answer);
        
        return answer;
    }
    
    static int[] countArr;
    static Map<String, Integer> idMap = new HashMap<>();
    static Map<String, String> map = new HashMap<>();
    static ArrayList<ArrayList<Integer>> list;
        
    static int[] sol(int k, int[] answer){
        
        for(int i=0; i<list.size(); i++){
            int cnt = 0;
            for(int j=0; j<list.get(i).size(); j++){
                int to = list.get(i).get(j);
                
                if(countArr[to] >= k) cnt++;
                
            }
            
            answer[i] += cnt;
        }
        return answer;
    }
	
}
