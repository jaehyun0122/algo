import java.util.Arrays;

public class 조합 {

    static int n=3, r=2;
    static int[] input;
    static int[] numbers;

    public static void main(String[] args) {

        input = new int[]{1,3,7};
        numbers = new int[r];

        solution(0,0);
    }

    private static void solution(int cnt, int start){
        if(cnt == r) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=start; i<n; i++){
            numbers[cnt] = input[i];
            solution(cnt+1, i+1);
            //중복
            //solution(cnt+1, i);
        }

    }
}
