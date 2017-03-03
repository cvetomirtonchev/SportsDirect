package shops;

public class Clothing extends Product {

	public enum ClothType{
		TSHIRTS,JEANS,JACKETS,SWIMWEAR,HOODIES,BEACHWEAR;
	}
	private ClothType clothType;
	
	public Clothing(String name, Brand brand, boolean forMen,double price , String size, int quantity, String productInfo,
			ClothType clothType) {
		super(name, brand, forMen,price, size, quantity, productInfo );
		this.clothType = clothType;
	}
	
	
}
