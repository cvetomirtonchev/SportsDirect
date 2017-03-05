package store;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	}

	public Collection<User> getUsers() {

		return Collections.unmodifiableCollection(users);
	}

	public void addUser(User u) {
		if (u != null) {
			users.add(u);
		}
	}

	public void addToCatalog(Product prod) {

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

	public void printCatalog() {
		System.out.println("==========WELCOME TO" + this.name + "===========");
		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, TreeSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					for (Product prod : e2.getValue()) {
						System.out.println("                                       :" + prod);
						prod.printProductInfo();
					}
				}

			}

		}
	}

	// print form price range
	public void printFromPriceRange(int startPrice, int endPrice) {
		if (startPrice > endPrice) {
			int change = 0;
			change = endPrice;
			endPrice = startPrice;
			startPrice = change;
		}
		System.out.println("==========WELCOME TO" + this.name + "===========");

		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, TreeSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					for (Product prod : e2.getValue()) {
						if (prod.getPrice() >= startPrice && prod.getPrice() <= endPrice) {
							System.out.println("                                       :" + prod);
							prod.printProductInfo();
						}

					}
				}

			}

		}
	}

	public void printColor(String color) {

		System.out.println("==========WELCOME TO" + this.name + "===========");

		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, TreeSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					for (Product prod : e2.getValue()) {
						if (prod.getColorSizeQuantity().containsKey(color)) {
							System.out.println("Color : " + color);
							for (Entry<String, Integer> e3 : prod.getColorSizeQuantity().get(color).entrySet()) {

								System.out.println(prod + " " + e3.getKey());

							}
						}
					}

				}
			}

		}

	}
	public void printSize(String size) {

		System.out.println("==========WELCOME TO" + this.name + "===========");

		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, TreeSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, TreeSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, TreeSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					for (Product prod : e2.getValue()) {
						for(Entry<String,TreeMap<String, Integer>> e3 : prod.getColorSizeQuantity().entrySet()){
							for(Entry<String,Integer> e4 : e3.getValue().entrySet()){
								if(e4.getKey().equals(size)){
									System.out.println(prod);
								}
							}
						}
							
							
					}

				}
			}

		}

	}

	public boolean checkAvailability(Product prod, String color, String size, int quantity) {
		Gender gen = prod.getGender();
		ProductType type = prod.getProductType();
		IStock stock = prod.getStock();

		if (this.catalog.get(gen).get(type).get(stock).contains(prod)) {
			if (prod.getColorSizeQuantity().containsKey(color)) {
				if (prod.getColorSizeQuantity().get(color).containsKey(size)) {
					if (prod.getColorSizeQuantity().get(color).get(size) >= quantity) {
						return true;
					} else {
						System.out.println("Not enough quantity in the store!");
						return false;
					}
				} else {
					System.out.println("No such size for this product!");
					return false;
				}
			} else {
				System.out.println("No such color for this product!");
				return false;
			}
		} else {
			System.out.println("No such product in the catalog!");
			return false;
		}

	}

	// ne sum dobavil da proverqva cvetovete razmera i nalichnosta
	// krasi kaza che za kolekciite ne trqbva da ima getters and setters
	// za tova reshih malko da te ulesnq
	public void giveProduct(User user, Product product, String color, String size, int quantity) {
		Gender gen = product.getGender();
		ProductType type = product.getProductType();
		IStock stock = product.getStock();

		if (this.catalog.containsKey(gen)) {
			if (this.catalog.get(gen).containsKey(type)) {
				if (this.catalog.get(gen).get(type).containsKey(stock)) {
					if (this.catalog.get(gen).get(type).get(stock).contains(product)) {
						user.addToBag(product, color, size, quantity);
						this.catalog.get(gen).get(type).get(stock).remove(product);
					}
				}
			}

		}

	}

	
	public Map<Gender, HashMap<ProductType, HashMap<IStock, TreeSet<Product>>>> getCatalog() {

		return Collections.unmodifiableMap(catalog);
	}

}
