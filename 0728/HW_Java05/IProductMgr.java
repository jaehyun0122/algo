import java.util.ArrayList;

public interface IProductMgr {

	void addProduct(Product p);
	ArrayList<Product> getAll();
	Product searchByNum(String PNum);
	Product searchByName(String PName);
	ArrayList<Product> getTV();
	ArrayList<Product> getRef();
	ArrayList<Refrigerator> getVolume();
	ArrayList<TV> getInch();
	void changePrice(int PNum, int price);
	void delete(String PNum);
	int getQprice();
	
}
