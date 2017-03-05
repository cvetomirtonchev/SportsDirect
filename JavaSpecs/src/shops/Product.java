package shops;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.TreeMap;

import store.IStock;

public abstract class Product implements Comparable<Product> {

	public enum Brand {
		NIKE, ADIDAS, PUMA, EVERLAST
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
	protected TreeMap<String, TreeMap<String, Integer>> colorSizeQuantity;
	protected ProductType productType;
	protected IStock stock;

	public Product(String name, Brand brand, Gender gender, double price, String productInfo) {

		this.name = name;
		this.brand = brand;
		this.gender = gender;
		this.productInfo = productInfo;
		this.price = price;
		this.colorSizeQuantity = new TreeMap<>();
		this.colorSizeQuantity.put("Black", new TreeMap<>());
		this.colorSizeQuantity.put("White", new TreeMap<>());
		this.colorSizeQuantity.put("Blue", new TreeMap<>());
		this.colorSizeQuantity.put("Yellow", new TreeMap<>());
	}

	protected void addSizeAndQuantity(String[] manSize, String[] womanSize) {

		if (this.gender.equals(gender.LADIES)) {
			for (int i = 0; i < womanSize.length; i++) {
				for (Entry<String, TreeMap<String, Integer>> e : this.colorSizeQuantity.entrySet()) {
					e.getValue().put(womanSize[i], new Random().nextInt(4));
				}
			}
		}
		if (this.gender.equals(gender.MEN)) {
			for (int i = 0; i < womanSize.length; i++) {
				for (Entry<String, TreeMap<String, Integer>> e : this.colorSizeQuantity.entrySet()) {
					e.getValue().put(manSize[i], new Random().nextInt(4));
				}
			}
		}
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

	public double getPrice() {
		return price;
	}

	public Map<String, TreeMap<String, Integer>> getColorSizeQuantity() {
		return Collections.unmodifiableMap(colorSizeQuantity);
	}

	public void printProductInfo() {

		for (Entry<String, TreeMap<String, Integer>> e : colorSizeQuantity.entrySet()) {
			System.out.println("Color: " + e.getKey());
			for (Entry<String, Integer> e2 : e.getValue().entrySet()) {
				System.out.println("size : " + e2.getKey() + "  quantity: " + e2.getValue());
			}
		}
	}

	@Override
	public String toString() {
		return " " + this.brand + " " + this.name + ", price:" + price;
	}

	@Override
	public int compareTo(Product p) {

		return 1;
	}

}
