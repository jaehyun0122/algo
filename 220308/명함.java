public class 명함 {
    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}};
        System.out.println(solution(sizes));

    }
    public static int solution(int[][] sizes){
        int answer = 0;
        int w = sizes[0][0];
        int h = sizes[0][1];
        for(int i=1; i<sizes.length; i++){
            for(int j=0; j<2; j++){
                System.out.println(sizes[i][j]);
                if(w < sizes[i][j]) w = sizes[i][j];
                if(h < sizes[i][j]){
                    if(w >= sizes[i][j]) continue;
                    w = sizes[i][j];
                }
            }
            for(int k=1; k<sizes[i].length; k++){
                if(h < sizes[i][k]){
                    if(w >= sizes[i][k]) continue;
                    w = sizes[i][k];
                }
            }
        }
        answer = w*h;
        return answer;
    }
}
