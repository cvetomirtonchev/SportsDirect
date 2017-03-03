package shops;

public class FootWear extends Product {

	public enum ShoesType {
	RUNNIG,BOOTS,SANDALS,FLIPFLOPS,FOOTBALL

	}
	private ShoesType shoesType;
	
	
	public FootWear(String name, Brand brand, boolean forMen,double price ,String size, int quantity, String productInfo,
			ShoesType shoesType) {
		super(name, brand, forMen,price, size, quantity, productInfo );
		this.shoesType = shoesType;
	}
	
	


}
