package product;

public class Refrigerator extends Product{

	public Refrigerator(int num, String name, int price) {
		super(num, name, price);
		this.str = "ref";
	}

	@Override
	public String toString() {
		return "Refrigerator [ref=" + ", num=" + num + ", name=" + name + ", price=" + price + "]";
	}
}
