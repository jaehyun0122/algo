package Book1.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class BookMgr implements IBookMgr {
	   private static BookMgr instance = new BookMgr();
	   public static BookMgr getInstance() {
		   return instance;
	   }
	   private BookMgr() {}
	   
	   private ArrayList<Book> books = new ArrayList <Book>();
	   
	   public void update(String isbn, String title) {
	      for(int i = 0; i < books.size(); i++) {
	         if( books.get(i).getIsbn().equals(isbn) )
	        	 books.get(i).setTitle(title);
	      }
	   }
	   public void remove(String isbn) {
	      for(int i = 0; i < books.size(); i++) {
	         if(books.get(i).getIsbn().equals(isbn)) {
	            books.remove(i);
	            break;
	         }
	      }
	   }
	   
	   public void add(Book book) {
	      books.add(book);
	   }
	   public ArrayList<Book> getList() {
	      ArrayList<Book> bookList = new ArrayList<Book>();
	      bookList.addAll(books);
		  return bookList;
	   }
	   
	   public Book searchByIsbn(String isbn){
	      for(int i=0; i< books.size(); i++) {
	         if(books.get(i).getIsbn().equals(isbn)) {
	        	 Book b = books.get(i);
	        	 return b;
	         }
	      }
	      return null;
	   }
	   
	   public ArrayList<Book> searchByTitle(String title) {
		  ArrayList<Book> bookList = new ArrayList<Book>();
		  for(int i=0; i < books.size(); i++) {
			  if(books.get(i).getTitle().contains(title))
				  bookList.add(books.get(i));
		  }
		  return bookList;
	   }
	   
	   public ArrayList<Book> getBooks() {
		  ArrayList<Book> bookList = new ArrayList<Book>();
		  for(int i=0; i < books.size(); i++) {
			  if(!(books.get(i) instanceof Magazine))
				  bookList.add(books.get(i));
		  }
		  return bookList;
	   }	   
	   
	   public ArrayList<Book> getMagazines() {
			  ArrayList<Book> bookList = new ArrayList<Book>();
			  for(int i=0; i <books.size(); i++) {
				  if(books.get(i) instanceof Magazine)
					  bookList.add(books.get(i));
			  }
			  return bookList;
		   }	   
	   
	   public int getTotalPrice() {
		   int sum = 0;
		   for(int i=0; i< books.size(); i++) {
			sum += books.get(i).getPrice();   
		   }
		return sum;
	   }
	   
	   
	   public double getPriceAvg() {
		   
		   int sum = 0;
		   double Avg = 0;
		   
		   for(int i=0; i< books.size(); i++) {
			sum += books.get(i).getPrice();
		   }
		   
		   Avg = (double)sum/books.size() ;
		   return Avg;
	   }
	   
	   public void buy(String isbn, int num) throws ISBNNotFoundException{
		   boolean bln = false;
		   for(int i = 0; i < books.size(); i++) {
		         if( books.get(i).getIsbn().equals(isbn) ) {
		        	 books.get(i).setQuantity(books.get(i).getQuantity()+num);	 
		        	 bln = true;
		         }
		      }
		   if(!bln) throw new ISBNNotFoundException();
	   }
	   
	   public void sell(String isbn, int num) throws ISBNNotFoundException, QuantityException{
		   boolean bln = false;
		   for(int i = 0; i < books.size(); i++) {
		         if( books.get(i).getIsbn().equals(isbn))  {
		        	 if(books.get(i).getQuantity() < num) throw new QuantityException();
		        	 books.get(i).setQuantity(books.get(i).getQuantity()-num);	 
		        	 bln = true;
		         }
		      }
		   if(!bln) throw new ISBNNotFoundException();
	   }
}
	
		  

