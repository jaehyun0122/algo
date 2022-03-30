import java.util.*;

public class 가위바위보 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		char[] ans = new char[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			b[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			if(a[i] == b[i]) ans[i] = 'D';
			else if((a[i]==1 && b[i]==3) || (a[i]==2 && b[i]==1) || (a[i]==3 && b[i]==2)) ans[i] = 'A';
			else ans[i] = 'B';
		}
		for(char res : ans) {
			System.out.println(res);
		}
	}

}
