package product;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		
		ProductMgr productmgr = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. TV 추가.");
			System.out.println("2. 냉장고 추가.");
			System.out.println("3. 전체 상품 검색.");
			System.out.println("4. 상품명으로 검색.");
			System.out.println("5. TV정보만 검색.");
			System.out.println("6. 냉장고정보만 검색");
			System.out.println("7. 상품번호로 삭제");
			System.out.println("8. 전체 재고상품 금액 검색");
			System.out.println("0. 종료");
			int sel = sc.nextInt();
			if(sel == 0) break;
			else if(sel == 1) {
				System.out.println("상품번호 : ");
				int num = sc.nextInt();
				System.out.println("상품명 : ");
				String name = sc.next();
				System.out.println("가격 : ");
				int price = sc.nextInt();
				TV tvProduct = new TV(num, name, price);
				productmgr.addTV(tvProduct);
			}
			else if(sel == 2) {
				System.out.println("상품번호 : ");
				int num = sc.nextInt();
				System.out.println("상품명 : ");
				String name = sc.next();
				System.out.println("가격 : ");
				int price = sc.nextInt();
				Refrigerator refProduct = new Refrigerator(num, name, price);
				productmgr.addRef(refProduct);
				
			}
			else if(sel == 3) {
				productmgr.getProduct();
			}
			else if(sel == 4) {
				System.out.println("상품명을 입력하세요 : ");
				String name = sc.next();
				productmgr.getOne(name);
			}
			else if(sel == 5) {
					productmgr.getTV();
			}
			else if(sel == 6) {
					productmgr.getRef();
			}
			else if(sel == 7) {
				System.out.println("삭제할 상품번호 입력 :");
				int num = sc.nextInt();
				productmgr.delte(num);
			}
			else if(sel == 8) {
				productmgr.getPrice();
			}
		}
		
	}

}
