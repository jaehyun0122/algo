import java.util.*;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1};
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1,30,5};
		
        ArrayList<Integer> list = new ArrayList<>();
        
        int time = 0;
        for(int i=0; i<progresses.length; i++){
            time = (int) Math.ceil((100-(double) progresses[i])/(double) speeds[i]);
            
            list.add(time);
        }
         
        System.out.println(sol(list));
	}

	
	 static ArrayList<Integer> sol(ArrayList<Integer> list){
	        ArrayList<Integer> res = new ArrayList<>();
	        int cnt = 1;
	        int prev = list.get(0);
	        int idx = 1;
	        
            for(int i=1; i<list.size(); i++){
                if(list.get(i) > prev) {
                    prev = list.get(i);
                    res.add(cnt);
                    cnt = 1;
                }
                else {
                	cnt++;
                }
       
            }
            res.add(cnt);

            return res;
	    }
}
