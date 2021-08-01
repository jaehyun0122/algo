package product;

public class ProductMgr {

	private static ProductMgr instance = new ProductMgr();
	private ProductMgr() {}
	public static ProductMgr getInstance() {
		return instance;
	}
	
	Product[] products = new Product[1000];
	int idx = 0;
	int tvN = 0;
	int refN = 0;
	
	public void addTV(TV tvProduct) {
		products[idx++] = tvProduct;
	}
	public void addRef(Refrigerator refProduct) {
		products[idx++] = refProduct;
	}
	public void getProduct() {
		for(int i=0; i<idx; i++) {
			System.out.println(products[i]);
		}
	}
	public void getOne(String name) {
		for(int i=0; i<idx; i++) {
			if(products[i].getName().equals(name)){
				System.out.println(products[i].toString());
				break;
			}
		}
	}
	public void getTV() {
		for(int i=0; i<idx; i++) {
			if(products[i].getStr().equals("TV"))
				System.out.println(products[i].toString());
		}
	}
	public void getRef() {
		for(int i=0; i<idx; i++) {
			if(products[i].getStr().equals("ref"))
				System.out.println(products[i].toString());
		}
	}
	public void delte(int num) {
		for(int i=0; i<idx; i++) {
			if(products[i].getNum() == num) {
				products[i] = products[idx-1];
				idx--;
				break;
			}
		}
	}
	public void getPrice() {
		int sum = 0;
		for(int i=0; i<idx; i++) {
			sum += products[i].getPrice();
		}
		System.out.println(sum);
	}
}
