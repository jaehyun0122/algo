
public class Phone {
	private int idx;
	private String name;
	private int price;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public Phone(int idx, String name, int price) {
		super();
		this.idx = idx;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Phone [idx=" + idx + ", name=" + name + ", price=" + price + "]";
	}
	
}
