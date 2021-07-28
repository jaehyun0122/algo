
public class TV extends Product{

	private int inch;
	public TV() {}
	public TV(String PNum, String PName,int price, int inch) {
		super(PNum, PName, price);
		this.inch = inch;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	@Override
	public String toString() {
		return "TV [inch=" + inch + ", getInch()=" + getInch() + ", getPNum()=" + getPNum() + ", getPName()="
				+ getPName() + ", getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity() + "]";
	}
	
}
