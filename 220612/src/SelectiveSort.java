import java.util.Arrays;

public class SelectiveSort {

	public static void main(String[] args) {

		int[] arr = {2,5,3,1,4};
		int[] res = solution(arr);
		for(int a : res) System.out.println(a);
	}

	    static int[] solution(int[] p) {
	        int[] answer = {};

	        int[] num = new int[p.length];

	        for(int i=0; i<p.length-1; i++){
	            int idx = i;
	            int min = 6;
	            for(int j=i+1; j<p.length; j++){
	                if(p[i] > p[j] && min > p[j]){
                        idx = j;
                        min = p[j];
	                }
	            }
            	int tmp = p[idx];
            	p[idx] = p[i];
            	p[i] = tmp;
            	if(idx != i) {
        		num[i]++;
        		num[idx]++;
            		
            	}
	        }

	        answer = num;
	        return answer;
	    }
}
