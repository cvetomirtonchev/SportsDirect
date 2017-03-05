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
	
	public Accessories(String name, Brand brand, Gender gender, double price, String productInfo, AccessType acessType) {
		super(name, brand, gender,price, productInfo );
		this.accessType = accessType;
		this.productType = ProductType.ACCESSORIES;
		this.stock = acessType;
		for (Entry<String, TreeMap<String, Integer>> e : this.colorSizeQuantity.entrySet()) {
			e.getValue().put("Unique", new Random().nextInt(4)+1);
		}
		
	}
}
