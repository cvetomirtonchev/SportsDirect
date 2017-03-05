package shops;

import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Random;

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
		String[] womanSize = {"35", "36", "37", "38", "39", "40", "41", "42"};
		String[] manSize = {"39", "40", "41", "42", "43", "44", "45", "46"};
		this.addSizeAndQuantity(manSize, womanSize);
	}
	
	


}
