import java.util.ArrayList;
import java.util.Collections;

public class 문제1 {
    public static void main(String[] args) {
        int[] str = new int[]{3,3,1,1,2,2,4,4,5,5};
// 1번 학생 : 1234512345  2번학생 : 2122232425  3번학생 : 3311224455
//
        for(int a:solution(str)) {
            System.out.print(a + " ");
        }
    }
    private static ArrayList<Integer> solution(int[] str){
            int[] one = new int[str.length];
            int[] two = new int[str.length];
            int[] three = new int[str.length];
         int num = 1;
        for(int i=0; i<str.length; i++){
            if(num==6) {
                num = 1;
                one[i] = num;
                num++;
                continue;
            }
            else {
                one[i] = num;
                num++;
            }
        }

        int cnt = 1;
        for(int i=0; i<str.length; i+=2){
            if(i > str.length+1) break;
            two[i] = 2;

            if(i+1 >= str.length) break;
            two[i+1] = cnt++;
        }


        cnt = 3;
        for(int i=0; i< str.length; i++){
            three[i] = cnt;
            if(i%2 == 1) {
                if (cnt == 4) cnt = 5;
                else {
                    cnt -= 2;
                    if (cnt == -1) cnt = 2;
                    else if (cnt == 0) cnt = 4;
                }
            }
        }
//        for(int a:one){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for(int a:two){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for(int a:three){
//            System.out.print(a+" ");
//        }
//        System.out.println();

        int[] result = new int[4];
        for(int i=0; i<str.length; i++){
            if(one[i] == str[i]) result[1]++;
            if(two[i]==str[i]) result[2]++;
            if(three[i]==str[i]) result[3]++;
        }

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=1; i<result.length; i++){
                if(result[i]==0)continue;
                else list.add(result[i]);
            }

        Collections.sort(list, Collections.reverseOrder());
//        System.out.println(list);
//        for(int a: result){
//            System.out.print(a+" ");
//        }
//        System.out.println();

            ArrayList<Integer> answer = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                for(int j=1; j<result.length; j++){
                    if(result[j]==0) continue;
                    if(result[j] == list.get(i)) answer.add(j);
                }
            }

        return answer;
    }

}
