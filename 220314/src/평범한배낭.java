import java.util.Scanner;

public class 평범한배낭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for(int i=1; i<=n; i++){
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }
        int[] d = new int[k+1];

        for(int i=1; i<=n; i++){
            for(int j=k; j>=w[i]; j--){
                d[j] = Math.max(d[j], v[i]+d[j-w[i]]);
            }
        }
        System.out.println(d[k]);
    }
}
