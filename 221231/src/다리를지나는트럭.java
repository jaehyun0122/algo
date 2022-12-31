import java.util.*;
public class 다리를지나는트럭 {

	public static void main(String[] args) {

		int bridge = 2;
		int weights = 10;
		int[] truck = {7,4,5,6};
		System.out.println(solution(bridge, weights, truck));
	}
	
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
        	q.add(0);
        }
        int sec = 0;
        int idx = 0;
        int curWeight = 0;
        while(idx < truck_weights.length){
            curWeight -= q.poll();
            sec++;
            if(curWeight+truck_weights[idx] <= weight){
                q.add(truck_weights[idx]);
                curWeight+=truck_weights[idx++];
            }else {
            	q.add(0);
            }
   
        }

        return sec+bridge_length;
    }
   
}
