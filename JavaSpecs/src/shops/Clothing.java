package shops;

import shops.Product.Gender;
import shops.Product.ProductType;
import store.IStock;

public class Clothing extends Product {

	public enum ClothType implements IStock{
		TSHIRTS,JEANS,JACKETS,SWIMWEAR,HOODIES,BEACHWEAR;
	}
	private ClothType clothType;
	
	public Clothing(String name, Brand brand,Gender gender, double price , String productInfo,	ClothType clothType) {
		super(name, brand, gender,price, productInfo );
		this.clothType = clothType;
		this.productType = ProductType.CLOTHING;
		this.stock = clothType;
		String[] womanSize = {"S", "M", "L", "XS"};
		String[] manSize = {"S", "M", "L", "XL"};
		this.addSizeAndQuantity(manSize, womanSize);

	}
	
	
}
