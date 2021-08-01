import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {

		ArrayList<Product> p = new ArrayList<Product>();
		ProductMgr pmg = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("0. break");
			System.out.println("1. TV정보 저장");
			System.out.println("2. 냉장고정보저장");
			System.out.println("3. 상품정보 전체 검색");
			System.out.println("4. 상품번호로 검색");
			System.out.println("5. 상품명으로 검색");
			System.out.println("6. TV정보 검색");
			System.out.println("7. 냉장고정보 검색");
			System.out.println("8. 400L 이상의 냉장고 검색");
			System.out.println("9. 50인치 이상의 TV검색");
			System.out.println("10. 상품가격 변경");
			System.out.println("11. 상품 삭제");
			System.out.println("12. 전체 재고 상품 금액");
			
			int sel = sc.nextInt();
			if(sel == 0) break;
			else if(sel == 1){
				System.out.print("상품번호 : ");
				String PNum = sc.next();
				System.out.print("상품이름 : ");
				String PName = sc.next();
				System.out.print("상품가격 : ");
				int price = sc.nextInt();
				System.out.println("inch : ");
				int inch = sc.nextInt();
				Product product = new TV(PNum, PName, price, inch);
				pmg.addProduct(product);
				
			}
			else if(sel == 2){
				System.out.print("상품번호 : ");
				String PNum = sc.next();
				System.out.print("상품이름 : ");
				String PName = sc.next();
				System.out.print("상품가격 : ");
				int price = sc.nextInt();
				System.out.print("용량(L) : ");
				int v = sc.nextInt();
				Product product = new Refrigerator(PNum, PName, price, v);
				pmg.addProduct(product);
				
			}
			else if(sel == 3){
				System.out.println(pmg.getAll());
			}
			else if(sel == 4){
				System.out.println("상품번호 입력 : ");
				String PNum = sc.next();
				System.out.println(pmg.searchByNum(PNum));
			}
			else if(sel == 5){
				System.out.println("상품명 입력 : ");
				String PName = sc.next();
				System.out.println(pmg.searchByName(PName));
				}
			else if(sel == 6){
				System.out.println("=====TV=====");
				System.out.println(pmg.getTV());
			}
			else if(sel == 7){
				System.out.println("=====냉장고=====");
				System.out.println(pmg.getRef());
			}
//			else if(sel == 8){
//				System.out.println("400L보다 용량이 큰 냉장고");
//				System.out.println(pmg.overV());
//			}
//			else if(sel == 9){
//				System.out.println("50인치보다 큰 TV");
//				System.out.println(pmg.overI());
//			}
			else if(sel == 10){
				System.out.println("변경할 상품번호 입력 : ");
				String PNum = sc.next();
				System.out.println("변경 가격 입력 : ");
				int price = sc.nextInt();
				pmg.changePrice(PNum, price);
			}
			else if(sel == 11){
				System.out.println("삭제할 상품 번호 입력 : ");
				String PNum = sc.next();
				pmg.delete(PNum);
			}
			else if(sel == 12){
				System.out.println(pmg.getQprice());
			}
		}
	}

}
