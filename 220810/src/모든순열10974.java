import java.io.*;

public class 모든순열10974 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		check = new boolean[number+1];
		arr = new int[number];
		
		permutation(number, 0);
	}

	static boolean[] check;
	static int[] arr;
	
	static void permutation(int num, int cnt) {
		
		if(cnt == num) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			System.out.print(sb);
			return;
		}
		
		for(int i=1; i<= num; i++) {
			if(check[i]) continue;
			arr[cnt] = i;
			check[i] = true;
			permutation(num, cnt+1);
			check[i] = false;
		}
	}
}
