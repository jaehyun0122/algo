import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 백준2751수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> a = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for(int t=0; t<n; t++) {
			a.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(a);
		for(int s : a) sb.append(s).append("\n");
		System.out.println(sb);
	}

}
