import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
public class 정규표현식 {

	public static void main(String[] args) {

		String pattern = "\\d";
		String str = "12342";
		
		boolean isMatch = Pattern.matches(pattern, str);
		System.out.println(isMatch);
	}

}
