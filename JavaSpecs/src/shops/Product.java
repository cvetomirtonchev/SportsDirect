package shops;

import java.util.ArrayList;
import java.util.TreeMap;

import store.IStock;

public abstract class Product {
	public enum Brand {
		NIKE,ADIDAS,PUMA,EVERLAST
	}
	
	public enum Gender {
		MEN, LADIES
	}
	
	public enum ProductType {
		FOOTWEAR, CLOTHING, ACCESSORIES
	}
	
	private String name;
	private Brand brand;
	private Gender gender; 
	private double price;
	private String productInfo;
	private TreeMap<String, Integer> sizeQuantity; 
	private ArrayList<String> colors;
	protected ProductType productType;
	protected IStock stock;
	
	public Product(String name, Brand brand, Gender gender ,double price, String productInfo) {
		
		this.name = name;
		this.brand = brand;
		this.gender = gender;
		this.productInfo = productInfo;
		this.price=price;
		this.sizeQuantity = new TreeMap<>();
	}

	public Gender getGender() {
		return gender;
	}

	public ProductType getProductType() {
		return productType;
	}

	public IStock getStock() {
		return stock;
	}
	
	
	
	

}
