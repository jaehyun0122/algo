package dto;

public class Book {

	int isbn;
	String name;
	String author;
	int price;
	String comment;
	
	Book(int isbn, String name, String author, int price, String comment){
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.price = price;
		this.comment = comment;
	}

	
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", author=" + author + ", price=" + price + ", comment="
				+ comment + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
