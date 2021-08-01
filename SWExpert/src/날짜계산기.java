import java.util.Scanner;

public class 날짜계산기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int i=0; i<T; i++) {
			int first_mon = sc.nextInt();
			int first_day = sc.nextInt();
			int last_mon = sc.nextInt();
			int last_day = sc.nextInt();
			int mon_result = 0;
			int result = 0;
			
			if(first_mon == last_mon) {
				result = last_day - first_day;
			}
			else{
				for(int j=(first_mon-1); j<last_mon-1; j++) {
					mon_result += day[j];
			}
			
		}
				result = mon_result + last_day - first_day + 1;
				System.out.println("#"+(i+1)+" "+result);
	}
  }
}
