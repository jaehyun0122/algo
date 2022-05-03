import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 다이얼5622 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] chArr = {
				{"ABC"},
				{"DEF"},
				{"GHI"},
				{"JKL"},
				{"MNO"},
				{"PQRS"},
				{"TUV"},
				{"WXYZ"},
		};
		
		String str = br.readLine();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<str.length(); i++) {
			String temp = Character.toString(str.charAt(i));
		
			for(int j=0; j<chArr.length; j++) {
				String strA = chArr[j][0];
//				System.out.println("비교문자 : "+strA+" temp : "+temp);
				if(strA.contains(temp)) {
//					System.out.println("list add : "+j);
					list.add(j);
					break;
				}
			}
		}
		int idx = 0;
		for(int i=0; i<list.size(); i++) {
			idx += list.get(i)+3;
		}
		System.out.println(idx);
	}

}
