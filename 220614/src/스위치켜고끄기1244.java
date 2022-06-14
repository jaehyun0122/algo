import java.util.Scanner;

public class 스위치켜고끄기1244 {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		for(int i=0; i<T; i++) {
			arr[i] = sc.nextInt();
		}
		int s_num = sc.nextInt();
		int gen = 0;
		int num = 0;
		for(int i=0; i<s_num; i++) {
			gen = sc.nextInt();
			num = sc.nextInt();
			if(gen == 1) {
				int cnt = 1;
				while(true) {
					if(num*cnt-1 >= T) break;
					arr[num*cnt-1] = arr[num*cnt-1] == 1? 0: 1;
					cnt++;
				}
			}
			else {
				int j = 1;
				arr[num-1] = arr[num-1] == 1 ? 0 : 1;
				while(true) {
					if(num-1-j < 0 || num-1+j>=T) {
						break;
					}
					if(arr[num-1-j] == arr[num-1+j]) {
						arr[num-1-j] = arr[num-1+j] = arr[num-1+j] == 1 ? 0 : 1;
						j++;
					}else break;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
		
	}

}