
public class Refrigerator extends Product{

	private int v;
	public Refrigerator(String PNum, String PName, int price, int v) {
		super(PNum, PName, price);
		this.v = v;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	@Override
	public String toString() {
		return "Refrigerator [v=" + v + ", getV()=" + getV() + ", getPNum()=" + getPNum() + ", getPName()=" + getPName()
				+ ", getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity() + "]";
	}
	
	
}
