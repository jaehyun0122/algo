package Book1.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTest  {
  	   
   static Scanner sc = new Scanner(System.in);
   static ArrayList<Book> books = new ArrayList <Book>();
   static int idx = 0;
   
   public static void main(String[] args) {
      
      BookMgr m = BookMgr.getInstance();
      
      while(true) {
         System.out.println("1. 책 추가.");
         System.out.println("2. 잡지 추가.");
         System.out.println("3. 모든 책 조회.");
         System.out.println("4. 책 제목 수정.");
         System.out.println("5. 책 삭제.");
         System.out.println("6. 책 검색.");
         System.out.println("7. 책 제목으로 검색.");
         System.out.println("8. 일반도서 검색.");
         System.out.println("9. 잡지 검색.");
         System.out.println("10. 도서가격 총합.");
         System.out.println("11. 도서가격 평균.");
         System.out.println("12. 구매");
         System.out.println("13. 판매");
         System.out.println("0. 종료.");
         int sel = sc.nextInt();
         if(sel == 0)
            break;
         else if(sel == 1) {
            //isbn번호 사용자로부터 입력.
            System.out.print("isbn번호 : ");
            String isbn = sc.next();
            //title 사용자로부터 입력.
            System.out.print("제목 : ");
            String title = sc.next();
            //author 사용자로부터 입력.
            System.out.print("저자 : ");
            String author = sc.next();
            //publisher 사용자로부터 입력
            System.out.print("출판사 : ");
            String publisher = sc.next();
            //price 사용자로부터 입력
            System.out.print("가격 : ");
            int price = sc.nextInt();
            //desc 사용자로부터 입력.
            System.out.print("설명 : ");
            String desc = sc.next();
            //입력받은 정보들로 book객체 생성해 idx번째 변수에 객체 생성
            Book b = new Book(isbn, title, author, publisher, price, desc);
            m.add(b);// Book 객체를 넣는다

            
         }
         else if(sel == 2) {
        	  //isbn번호 사용자로부터 입력.
             System.out.print("isbn번호 : ");
             String isbn = sc.next();
             //title 사용자로부터 입력.
             System.out.print("제목 : ");
             String title = sc.next();
             //author 사용자로부터 입력.
             System.out.print("저자 : ");
             String author = sc.next();
             //publisher 사용자로부터 입력
             System.out.print("출판사 : ");
             String publisher = sc.next();
             //price 사용자로부터 입력
             System.out.print("가격 : ");
             int price = sc.nextInt();
             //desc 사용자로부터 입력.
             System.out.print("설명 : ");
             String desc = sc.next();
             System.out.print("year : ");
             String year = sc.next();
             System.out.print("month : ");
             String month = sc.next();
             //입력받은 정보들로 book객체 생성해 idx번째 변수에 객체 생성
             Book b = new Magazine(isbn, title, author, publisher, price, desc, year, month);
             m.add(b);
         }
         else if(sel == 3) {
            System.out.println(m.getList());
         }
         
         else if(sel == 4) {
            System.out.print("isbn번호 : ");
            String isbn = sc.next();
            System.out.print("제목 : ");
            String title = sc.next();
            m.update(isbn, title);
         }
         else if(sel == 5) {
            System.out.print("isbn번호 : ");
            String isbn = sc.next();
            m.remove(isbn);
         }
         else if(sel ==6) {
            System.out.print("isbn번호 : ");
            String isbn = sc.next();
            
            System.out.println(m.searchByIsbn(isbn));
         }
         
         else if(sel == 7) {
             System.out.print("책 제목 : ");
             String title = sc.next();
             ArrayList<Book> bookList = new ArrayList<Book>();
             System.out.println(m.searchByTitle(title));
             
          }
         
         else if(sel == 8) {
             ArrayList<Book> bookList = new ArrayList<Book>();
             bookList = m.getBooks();
             for(Book l : bookList) {
            	 System.out.println(l);
             }
          }       
         else if(sel == 9) {
             ArrayList<Book> bookList = new ArrayList<Book>();
             bookList = m.getMagazines();
             for(Book l : bookList) {
            	 System.out.println(l);
             }
          } 
         
         else if(sel == 10) {
           	 System.out.println(m.getTotalPrice());
          } 
         
         else if(sel == 11) {
           	 System.out.println(m.getPriceAvg());
             
          } 
         
         else if(sel == 12) {
             System.out.print("도서번호 : ");
             String isbn = sc.next();
             
             System.out.print("구매 개수 : ");
             int num = sc.nextInt();
             
             try {
            	 m.buy(isbn, num);
			} catch (ISBNNotFoundException e) {
			}
         }
             
         else if(sel == 13) {
             System.out.print("도서번호 : ");
             String isbn = sc.next();
             
             System.out.print("판매 개수 : ");
             int num = sc.nextInt();
             
             try {
				m.sell(isbn, num);
			} catch (ISBNNotFoundException e) {
			} catch (QuantityException e) {
			}
         }         
          
      }
   }  
}