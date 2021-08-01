
public class Product {

	public Product() {}
	private String PNum;
	private String PName;
	private int price;
	private String quantity;
	public String getPNum() {
		return PNum;
	}
	public void setPNum(String pNum) {
		PNum = pNum;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [PNum=" + PNum + ", PName=" + PName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	public Product(String pNum, String pName, int price) {
		super();
		PNum = pNum;
		PName = pName;
		this.price = price;
	}
	
	
}
