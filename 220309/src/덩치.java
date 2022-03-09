import java.util.Scanner;

public class 덩치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextByte();
        int[][] arr = new int[T][T];

        for(int tc=0; tc<T; tc++){
                arr[tc][0] = sc.nextInt();
                arr[tc][1] = sc.nextInt();
        }
        for(int i=0; i<arr.length;i++){
            int cnt = 1;
            for(int j=0; j<arr.length; j++){
                if(i == j) continue;
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) cnt++;
            }
            System.out.print(cnt+" ");
        }
    }
}
