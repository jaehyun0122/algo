import java.util.Scanner;

public class 부분집합 {

    static int N, total;
    static boolean[] check;
    static int[] input;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        check = new boolean[N];
        total = 0;

        for(int i=0; i<N; i++){
            input[i] = sc.nextInt();
        }
        solution(0);
        System.out.println(total);
    }

    private static void solution(int cnt){
        if(cnt == N) {
            total++;
            for(int i=0; i<N; i++){
                System.out.print((check[i]?input[i]:"X")+" ");
            }
            System.out.println();
            return;
        }

        check[cnt] = true;
        solution(cnt+1);
        check[cnt] = false;
        solution(cnt+1);
    }
}
