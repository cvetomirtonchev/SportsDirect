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
	
	
	public FootWear(String name, Brand brand, Gender gender, double price , String productInfo,	ShoesType shoesType, String color, String size, int quantity) {
		super(name, brand, gender,price, productInfo, color, size, quantity );
		this.shoesType = shoesType;
		this.productType = ProductType.FOOTWEAR;
		this.stock = shoesType;
	}


}
