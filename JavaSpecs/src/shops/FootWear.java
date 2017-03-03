package shops;

import shops.Product.Gender;
import store.IStock;

public class FootWear extends Product {

	public enum ShoesType implements IStock{
	RUNNIG,BOOTS,SANDALS,FLIPFLOPS,FOOTBALL

	}
	private ShoesType shoesType;
	
	
	public FootWear(String name, Brand brand, Gender gender, double price , String productInfo,	ShoesType shoesType) {
		super(name, brand, gender,price, productInfo );
		this.shoesType = shoesType;
		this.productType = ProductType.FOOTWEAR;
		this.stock = shoesType;
	}
	
	


}
