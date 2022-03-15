package src;

import java.util.Scanner;

public class 밀비급일 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            if(str.equals("END")) break;
            char[] arr = new char[str.length()];
            char[] copy = new char[str.length()];

            for(int i=0; i<str.length(); i++) {
                copy[(Math.abs(i-str.length()))-1] = str.charAt(i);
            }

            for(char c : copy) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
