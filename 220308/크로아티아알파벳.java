import java.util.Scanner;

public class 크로아티아알파벳 {
    public static void main(String[] args) {
        String[] str = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = 0;
        for(int i=0; i<str.length; i++){
                if(input.contains(str[i])) {
                    count++;
                    input = input.replace(str[i],"*");
                }
        }
        System.out.println(input.length());
    }
}
