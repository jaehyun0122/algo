public class 약수 {
    public static void main(String[] args) {
        int n = 12;

        System.out.println(solution(n));
    }
    public static int solution(int n){
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(i == 0) break;
            if(n%i == 0){
                answer += i;
            }
        }
        return answer;
    }
}
