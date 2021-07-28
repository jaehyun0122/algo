package Book1.Book;

import java.util.ArrayList;

public interface IBookMgr {
	ArrayList<Book> getList();
	Book searchByIsbn(String isbn);
	void add(Book book);
	void remove(String isbn);
	void update(String isbn, String title);
	int getTotalPrice();
	double getPriceAvg();
	ArrayList<Book> searchByTitle(String title);
	ArrayList<Book> getBooks();
	ArrayList<Book> getMagazines();
	void buy(String isbn, int num) throws QuantityException, ISBNNotFoundException;
	void sell(String isbn, int num) throws ISBNNotFoundException, QuantityException;
	
}
