import java.util.*;

public class sol1 {

    public static void main(String[] args) {
        long[] H = new long[]{3,2,1,1,3};

        ArrayList<ArrayList> a = solution(H);

        for(int i=0; i<a.size(); i++){
            System.out.println(a.get(i).toString());
        }

    }

    static ArrayList<ArrayList> solution(long[] H){
        long max = 0;
        for(int i=0; i<H.length; i++){
            max = H[i]>max?H[i]:max;
        }
        long[][] answer = new long[(int) max+1][(int) max+1];
        // 높이 i 비교
        for(int i=1; i<= max; i++){

            boolean[] isVisited = new boolean[H.length];
            for(int j=0; j<H.length; j++){
                if(H[j] == i ) {
                    isVisited[j] = true;
                    answer[i][1]++;
                    for(int k=j-1; k>=0; k--){
                        if(H[k] >= i && (k !=0 || !isVisited[k])) {
                            answer[i][1]++;
                        }
                    }
                }
                if(j>=H.length-1){
                    isVisited = new boolean[H.length];

                    if(H[j-1]>=i) {
                        answer[i][1]++;
                        isVisited[j] = true;

                        for(int r=H.length-3; r>=0; r--){
                            if(H[r] >= i) {
                                answer[i][1]++;
                            }
                        }
                    }
                }
            }

        }
        long[][] result = new long[answer.length][1];
        ArrayList<ArrayList> list = new ArrayList<>();
        for(int i=1; i<answer.length; i++){
            ArrayList<Long> alist = new ArrayList<>();
            if(answer[i][1] != 0) {
                result[i][0] = answer[i][1];
                alist.add((long) i);
                alist.add(result[i][0]);
                list.add(alist);
            }
        }

        return list;
    }
}
