import java.util.Scanner;

public class 스위치켜고끄기1244 {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		//스위치 배열에 값 넣음
		for(int i=0; i<T; i++) {
			arr[i] = sc.nextInt();
		}
		int s_num = sc.nextInt();
		int gen = 0;
		int num = 0;
		for(int i=0; i<s_num; i++) {
			gen = sc.nextInt();
			num = sc.nextInt();
			//남자
			if(gen == 1) {
				for(int j=1; j<=T/num; j++) {
					arr[(num*j)-1] = arr[(num*j)-1] ==1? 0:1;
				}
			}
			//여자
			else {
				arr[num-1] = arr[num-1] == 1? 0: 1;
				for(int j=1; j<num; j++) {
					if(arr[num-j-1] != arr[num+j-1] || num-j-1 < 0 || num+j-1 > T-1) break;
					
					arr[num-j-1]= arr[num+j-1] = arr[num-j-1] == 1? 0:1;
				}
			}
		}
		for(int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0)
				System.out.println();
		}
		
	}

}