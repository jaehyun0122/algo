import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
               
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        
        int[] dp = new int[M+1];
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            W[i] = w;
            V[i] = v;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=M; j>=W[i]; j--){
                dp[j] = Math.max(V[i]+dp[j-W[i]], dp[j]);
            }    
        }
        
        System.out.print(dp[M]);
        
    }
}