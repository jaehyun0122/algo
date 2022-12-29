import java.util.*;
public class test {

	public static void main(String[] args) {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = 
			{
					{2, 5, 3},
					{4, 4, 1},
					{1, 7, 3}
			};
		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int idx = commands[i][2]-1;
            
            int[] tmp = new int[end-start+1];
            int tIdx = 0;
            for(int j=start; j<=end; j++) {
                tmp[tIdx] = array[j];
                tIdx++;
            }
            Arrays.sort(tmp);
            answer[cnt] = tmp[idx];
            cnt++;
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
