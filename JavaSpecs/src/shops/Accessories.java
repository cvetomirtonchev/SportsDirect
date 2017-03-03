package shops;

public class Accessories extends Product {
	public enum AcessType{
		BELTS,GLASSES,WATCHES,HATS
	}
	private AcessType acessType;
	
	public Accessories(String name, Brand brand, boolean forMen,double price, String size, int quantity, String productInfo,
			AcessType acessType) {
		super(name, brand, forMen,price, size, quantity, productInfo );
		this.acessType = acessType;
	}
}
