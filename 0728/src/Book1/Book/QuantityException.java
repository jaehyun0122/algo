package Book1.Book;

public class QuantityException extends Exception {

	public QuantityException() {
		System.out.println("재고가 없습니다.");
	}
}
