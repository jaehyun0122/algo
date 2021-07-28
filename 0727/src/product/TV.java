package product;

public class TV extends Product{

	public TV(int num, String name, int price) {
		super(num, name, price);
		this.str = "TV";
	}
	
	@Override
	public String toString() {
		return "TV [tv=" + ", num=" + num + ", name=" + name + ", price=" + price + "]";
	}
}