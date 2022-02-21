
import java.util.*;

public class 백준1755숫자놀이 {

	static class dic implements Comparable<dic>{
		int num;
		String str;
		
		dic(int num, String str){
			this.num = num;
			this.str = str;
		}

		// 문자열 순으로 정렬.
		@Override
		public int compareTo(dic o) {
			return this.str.compareTo(o.str);
		}
	}
	
	static String[] eng = {"zero", "one","two","three","four","five"
			,"six","seven","eight","nine"
	};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// m,n 입력
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		// 배열저장할 리스트
		ArrayList<dic> list = new ArrayList<>();
		
		// m~n까지
		for(int i=m; i<=n; i++) {
			// 한자리 숫자이면
			if(i/10 == 0) {
				// 해당 숫자와 숫자 문자를 dic클레스에 저장한다.
				list.add(new dic(i, eng[i]));
			}
			// 두자리 숫자이면
			else {
				// 십의자리 숫자와 일의 자리 숫자를 나눠서 판단한다.
				int sib = i/10;
				int ill = i%10;
				list.add(new dic(i, eng[sib]+eng[ill]));
			}
		}
		// list배열을 문자순으로 정렬한다.
		Collections.sort(list);
		// 10개를 카운트할 변수
		int cnt = 0;
		// 리스트 사이즈만큼 돌면서
		for(int i=0; i<list.size(); i++) {
			// 리스트의 정보를 출력한다.
			System.out.print(list.get(i).num+" ");
			// 하나의 숫자가 출력될 때 카운트해준다.
			cnt++;
			// 카운트가 10의 단위가 되면 개행을 해준다.
			if(cnt%10 == 0) System.out.println();
		}
	}

}
