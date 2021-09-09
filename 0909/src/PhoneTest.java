
public class PhoneTest {
	//이 프로젝트에 mysql jar파일을 설정
	//PhoneManager를 마저 구현
	//아래 메인함수에서 적당히 동작을 테스트하시오.
	public PhoneTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공~~");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		PhoneTest phoneTest = new PhoneTest();
        PhoneManager pm = new PhoneManager();
        for(Phone list : pm.selectAll()) {
            System.out.println(list);
        }
        System.out.println(pm.selectOne(1));
//        pm.insertPhone(new Phone(1, "kim", 2000));
		
	}
}
