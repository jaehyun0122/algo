package Book1.Book;

public class ISBNNotFoundException extends Exception{
	
	public ISBNNotFoundException() {
		System.out.println("isbn번호가 다릅니다.");
	}
}
