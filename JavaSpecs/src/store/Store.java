package store;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

import shops.Accessories.AccessType;
import shops.Product;
import shops.Product.Gender;
import shops.Product.ProductType;
import users.User;

public class Store {
	
	private String name = "Sports Direct";
	private String address;
	private TreeSet<User> users;
	private HashMap<Gender, HashMap<ProductType, HashMap<IStock, TreeSet<Product>>>> catalog;
		
	public Store(String address) {
		this.address = address;
		this.users = new TreeSet<>(new CompareByID());
		this.catalog = new HashMap<>();
		this.catalog.put(Gender.LADIES, new HashMap<>());
		this.catalog.put(Gender.MEN, new HashMap<>());
		this.catalog.get(Gender.LADIES).put(ProductType.ACCESSORIES, new HashMap<>());
		this.catalog.get(Gender.LADIES).put(ProductType.FOOTWEAR, new HashMap<>());
		this.catalog.get(Gender.LADIES).put(ProductType.CLOTHING, new HashMap<>());
		this.catalog.get(Gender.MEN).put(ProductType.ACCESSORIES, new HashMap<>());
		this.catalog.get(Gender.MEN).put(ProductType.FOOTWEAR, new HashMap<>());
		this.catalog.get(Gender.MEN).put(ProductType.CLOTHING, new HashMap<>());
		
		
	}

	public Collection<User> getUsers() {
		
		return Collections.unmodifiableCollection(users);
	}
	
	public void addUser (User u) {
		if (u != null) {
			users.add(u);
		}
	}
	
	public void addToCatalog (Product prod) {
		
		Gender gen = prod.getGender();
		ProductType type = prod.getProductType();
		IStock stock = prod.getStock();
		
		if (!this.catalog.containsKey(gen)) {
			this.catalog.put(gen, new HashMap<>());
		}
		if (!this.catalog.get(gen).containsKey(type)) {
			this.catalog.get(gen).put(type, new HashMap<>());
		}
		if (!this.catalog.get(gen).get(type).containsKey(stock)) {
			this.catalog.get(gen).get(type).put(stock, new TreeSet<>());
		}
		
		this.catalog.get(gen).get(type).get(stock).add(prod);
	}

}
