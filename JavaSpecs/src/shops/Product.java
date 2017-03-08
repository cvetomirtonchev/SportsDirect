package shops;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.TreeMap;

import store.IStock;

public abstract class Product  {

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
	private String color;
	private String size;
	private int quantity;
	protected ProductType productType;
	protected IStock stock;

	public Product(String name, Brand brand, Gender gender, double price, String productInfo, String color, String size, int quantity) {

		this.name = name;
		this.brand = brand;
		this.gender = gender;
		this.productInfo = productInfo;
		this.price = price;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
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

	public String getName() {
		return name;
	}
	
	public Brand getBrand() {
		return brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return " " + this.brand + " " + this.name + ", price:" + price +", color" +color +
				", size " + size + ", quantity "+ quantity;
	}


	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand != other.brand)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getSize() {
		return size;
	}
	public String getColor() {
		return color;
	}
	
	

}
