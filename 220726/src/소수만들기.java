import java.util.Arrays;

public class 소수만들기 {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4};
		arr= new int[3];
		res = 0;
		
		com(nums, 0, 0);
		System.out.println(res);
	}
	static int res;
	static int[] arr;
	
	static void com(int[] nums, int cnt, int start) {
		if(cnt == 3) {
			if(isPrime(arr)) {
				System.out.println(Arrays.toString(arr));
				res++;
				return;
			}
			return;
		}
		
		for(int i=start; i<nums.length; i++) {
			arr[cnt] = nums[i];
			com(nums, cnt+1, i+1);
		}
		
	}
	
	static boolean isPrime(int[] sumArr) {
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += sumArr[i];
		}
		
		for(int i=2; i<= (int)Math.sqrt(sum); i++) {
			if(sum % i == 0) return false;
		}
		
		return true;
		
	}

}
