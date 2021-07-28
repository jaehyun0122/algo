package Book1.Book;

public class Magazine extends Book {

	private String year;
	private String month;
	
	public Magazine(){

	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, String year, String month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
		
	}


	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", getYear()=" + getYear() + ", getMonth()=" + getMonth()
				+ ", getQuantity()=" + getQuantity() + ", getIsbn()=" + getIsbn()
				+ ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher()
				+ ", getPrice()=" + getPrice() + "]";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
}
