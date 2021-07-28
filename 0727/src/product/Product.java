package product;

public class Product {
	
	int num;
	String name;
	int price;
	String str;
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Product() {}
	public Product(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	
	
}
