import java.util.Scanner;

public class 사칙연산유효성검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int ans = 1;
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= n; i++) {
				String[] s = sc.nextLine().split(" ");
				// n이 짝수면 볼필요 없다.
				if (n % 2 == 0) {
					ans = 0;
				}
				// n이 홀수 일때
				else {
					// n/2까지 연산자가 있는지
					if(i <= n/2) {
							if (s[1].charAt(0) == '/' || s[1].charAt(0) == '+' || s[1].charAt(0) == '-' || s[1].charAt(0) == '*') ans = 1;
					}
					// n/2 +1 부터 숫자로만 되어있는지
					else {
							if (s[1].charAt(0) == '/' || s[1].charAt(0) == '+' || s[1].charAt(0) == '-' || s[1].charAt(0) == '*') ans = 0;
					}
					
				}

			}
			System.out.print("#" + tc + " " + ans);
			System.out.println();
		}
	}
}