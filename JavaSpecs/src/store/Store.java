package store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

import shops.Accessories.AccessType;
import shops.Product;
import shops.Product.Brand;
import shops.Product.Gender;
import shops.Product.ProductType;
import users.User;

public class Store {

	private String name = "Sports Direct";
	private String address;
	private TreeSet<User> users;
	private HashMap<Gender, HashMap<ProductType, HashMap<IStock, HashSet<Product>>>> catalog;

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
			this.catalog.get(gen).get(type).put(stock, new HashSet<>());
		}

		this.catalog.get(gen).get(type).get(stock).add(prod);
	}

	public void printCatalog() {
		System.out.println("==========WELCOME TO" + this.name + "===========");
		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, HashSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, HashSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, HashSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					for (Product prod : e2.getValue()) {
						System.out.println("                                       :" + prod);

					}
				}

			}

		}
	}

	public void printFromPriceRange(int startPrice, int endPrice) {
		if (startPrice > endPrice) {
			int change = 0;
			change = endPrice;
			endPrice = startPrice;
			startPrice = change;
		}
		System.out.println("==========WELCOME TO" + this.name + "===========");

		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, HashSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, HashSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, HashSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					for (Product prod : e2.getValue()) {
						if (prod.getPrice() >= startPrice && prod.getPrice() <= endPrice) {
							System.out.println("                                       :" + prod);

						}

					}
				}

			}

		}
	}

	public void printColor(String color) {

		System.out.println("==========WELCOME TO" + this.name + "===========");

		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, HashSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, HashSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, HashSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					System.out.println("                                   Color: " + color);
					for (Product prod : e2.getValue()) {
						if (prod.getColor().equals(color)) {
							System.out.println(prod);

						}
					}
				}

			}
		}

	}

	public void printSize(String size) {

		System.out.println("==========WELCOME TO" + this.name + "===========");

		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, HashSet<Product>>>> e : catalog.entrySet()) {
			System.out.println("     For: " + e.getKey());
			for (Entry<ProductType, HashMap<IStock, HashSet<Product>>> e1 : e.getValue().entrySet()) {
				System.out.println("             Type: " + e1.getKey());
				for (Entry<IStock, HashSet<Product>> e2 : e1.getValue().entrySet()) {
					System.out.println("                      -----Sort: " + e2.getKey());
					System.out.println("                              With size : " + size);
					for (Product prod : e2.getValue()) {
						if (prod.getSize().equals(size)) {
							System.out.println(prod);
						}
					}
				}
			}
		}
	}

	//
	// public void printByLabel(Product.Brand){
	//
	// }

	public boolean checkAvailability(Product prod, int quantity) {
		
		Gender gen = prod.getGender();
		ProductType type = prod.getProductType();
		IStock stock = prod.getStock();
		HashSet<Product> pr_set = this.catalog.get(gen).get(type).get(stock);
		if (pr_set.contains(prod)) {
			if (prod.getQuantity() >= quantity) {
				return true;
			} 
			else {
				System.out.println("Not enough quantity in the store!");
				return false;
			}
		}
		else {
			System.out.println("No such product in the catalog!");
			return false;
		}
	}


	public void removeFromCatalog(Product prod) {
		HashSet<Product> temp = this.catalog.get(prod.getGender()).get(prod.getProductType()).get(prod.getStock());
		for (Product p : temp) {
			if (p == prod) {
				p.setQuantity(p.getQuantity() - 1);
				break;
			}
		}
	}

	public void giveProduct(User user, Product product, int quantity) {
		Gender gen = product.getGender();
		ProductType type = product.getProductType();
		IStock stock = product.getStock();

		if (this.catalog.containsKey(gen)) {
			if (this.catalog.get(gen).containsKey(type)) {
				if (this.catalog.get(gen).get(type).containsKey(stock)) {
					if (this.catalog.get(gen).get(type).get(stock).contains(product)) {
						user.addToBag(product, quantity);
						this.catalog.get(gen).get(type).get(stock).remove(product);
					}
				}
			}

		}

	}

	public Map<Gender, HashMap<ProductType, HashMap<IStock, HashSet<Product>>>> getCatalog() {

		return Collections.unmodifiableMap(catalog);
	}

}
