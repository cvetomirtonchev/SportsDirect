package shops;

import shops.Product.Gender;
import shops.Product.ProductType;
import store.IStock;

public class Clothing extends Product {

	public enum ClothType implements IStock{
		TSHIRTS,JEANS,JACKETS,SWIMWEAR,HOODIES,BEACHWEAR;
	}
	private ClothType clothType;
	
	public Clothing(String name, Brand brand,Gender gender, double price , String productInfo,	ClothType clothType, String color, String size, int quantity) {
		super(name, brand, gender,price, productInfo, color, size, quantity  );
		this.clothType = clothType;
		this.productType = ProductType.CLOTHING;
		this.stock = clothType;

	}
	
	
}
