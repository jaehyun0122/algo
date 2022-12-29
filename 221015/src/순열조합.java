import java.util.*;
public class 순열조합 {

    static int n = 3,r=3;
    static boolean[] check;
    static int[] numbers;

    public static void main(String[] args) {
        numbers = new int[r];
        check = new boolean[n+1];
        solution(0);

    }

    private static void solution(int cnt){
        if(cnt == r) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

            for(int i=1; i<=n; i++) {
                if (check[i]) continue;

                numbers[cnt] = i;
                check[i] = true;

                solution(cnt + 1);

                check[i] = false;
            }
    }
}

