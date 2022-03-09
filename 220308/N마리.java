public class N마리 {


    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4,5,5,55,1,2,3};

        System.out.println(solution(nums));

    }

    public static int solution(int[] nums){
        int result = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = nums[i] > max?  nums[i] : max;
        }
        int[] arr = new int[max+1];
       for(int i=0; i<nums.length; i++){
            if(arr[nums[i]] != 1) {
                arr[nums[i]]++;
                result++;
            }
        }
        int answer = result >= (nums.length)/2 ? (nums.length)/2 : result;
        return answer;
    }
}
