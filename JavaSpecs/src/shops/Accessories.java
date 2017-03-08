package shops;

import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Random;

import shops.Product.Gender;
import shops.Product.ProductType;
import store.IStock;

public class Accessories extends Product {
	public enum AccessType implements IStock{
		BELTS,GLASSES,WATCHES,HATS
	}
	private AccessType accessType;
	
	public Accessories(String name, Brand brand, Gender gender, double price, String productInfo, AccessType acessType, String color, String size, int quantity) {
		super(name, brand, gender,price, productInfo, color, size, quantity  );
		this.accessType = accessType;
		this.productType = ProductType.ACCESSORIES;
		this.stock = acessType;
	}
}
