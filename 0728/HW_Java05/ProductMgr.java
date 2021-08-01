import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.model.core.Ref;

public class ProductMgr {

	private static ProductMgr instance = new ProductMgr();
	private ProductMgr() {}
	public static ProductMgr getInstance() {
		return instance;
	}
	private ArrayList<Product> products = new ArrayList<Product>();
	
	//상품저장
	public void addProduct(Product p) {
		products.add(p);
	}
	//상품 전체 검색
	public ArrayList<Product> getAll(){
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.addAll(products);
		return productList;
	}
	//상품번호로 검색
	public ArrayList<Product> searchByNum(String PNum) {
		ArrayList<Product> productList = new ArrayList<Product>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getPNum().equals(PNum)) {
				productList.add(products.get(i));
				return productList;
			}
		} return null;
	}
	//상품명으로 검색
	public ArrayList<Product> searchByName(String PName) {
		ArrayList<Product> productList = new ArrayList<Product>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getPName().equals(PName)) {
				productList.add(products.get(i));
				return productList;
			}
		}
		return null;
	}
	//TV정보 검색
	public ArrayList<Product> getTV(){
		ArrayList<Product> productList = new ArrayList<Product>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getClass() == TV.class) {
				productList.add(products.get(i));
				return productList;
			}
		}
		return null;
	}
	//냉장고 정보 검색
	public ArrayList<Product> getRef(){
		ArrayList<Product> productList = new ArrayList<Product>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getClass() == Refrigerator.class) {
				productList.add(products.get(i));
				return productList;
			}
		}
		return null;
	}
	// 냉장고 > 400
//	public ArrayList<Product> overV(){
//		
//		
//	}
	
	// TV > 50
//	public ArrayList<TV> overI(){
//		
//	}
	// 상품 번호, 가격을 받아 가격 변경
	public void changePrice(String PNum, int price) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getPNum().equals(PNum)) {
				products.get(i).setPrice(price);
			}
		}
	}
	public void delete(String PNum) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getPNum().equals(PNum)) {
				products.remove(i);
			}
		}
	}
	public int getQprice(){
		int sum = 0;
		for(int i=0; i<products.size(); i++) {
			sum += products.get(i).getPrice();
		}
		return sum;
	}
	
}

//System.out.println("11. 전체 재고 상품 금액");