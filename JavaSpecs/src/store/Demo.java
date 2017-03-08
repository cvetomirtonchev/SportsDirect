package store;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import shops.Accessories;
import shops.Clothing;
import shops.Clothing.ClothType;
import shops.Accessories.AccessType;
import shops.FootWear;
import shops.Product;
import shops.FootWear.ShoesType;
import shops.Product.Brand;
import shops.Product.Gender;
import shops.Product.ProductType;
import users.User;
import users.User.InvalidEmailException;
import users.User.InvalidPasswordException;
import users.User.InvalidUsernameException;

public class Demo {
	
	public static void main(String[] args) throws InvalidEmailException, InvalidUsernameException, InvalidPasswordException {
		
		// testing new features
		
		Store store = new Store("Sofia");
		
			
		User gosho = new User("Georgi", "Baraban1", "Baraban1", "georgi@abv.bg", store);
		store.addUser(gosho);
		
		String [] colors = {"Green", "Red", "Blue", "Black", "White", "Yellow"};
		int col = colors.length;
		
		String [] size = {"35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46"};
		int sizeL = size.length;
		
		ArrayList<Product> products = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			Random r = new Random();
			int type = r.nextInt(3);
			if (type == 0) {
				store.addToCatalog(new FootWear("Air", Brand.values()[r.nextInt(Brand.values().length)], Gender.values()[r.nextInt(Gender.values().length)], r.nextDouble()*100 +45, "Leather",
						ShoesType.values()[r.nextInt(ShoesType.values().length)], colors[r.nextInt(col)], size[r.nextInt(sizeL)], r.nextInt(5)+1));
			
			}
			if (type == 1) {
				store.addToCatalog(new Accessories("Mile", Brand.values()[r.nextInt(Brand.values().length)],  Gender.values()[r.nextInt(Gender.values().length)], r.nextDouble()*100 +15, "Cool",
						AccessType.values()[r.nextInt(AccessType.values().length)], colors[r.nextInt(col)], size[r.nextInt(sizeL)], r.nextInt(5)+1));
			}
			if (type == 2) {
				store.addToCatalog(new Clothing("Stone", Brand.values()[r.nextInt(Brand.values().length)],  Gender.values()[r.nextInt(Gender.values().length)],  r.nextDouble()*100 +15, "Velur",
						ClothType.values()[r.nextInt(ClothType.values().length)], colors[r.nextInt(col)], size[r.nextInt(sizeL)], r.nextInt(5)+1));
			
			}
		}
		for (Entry<Gender, HashMap<ProductType, HashMap<IStock, HashSet<Product>>>> e : store.getCatalog().entrySet()) {
			for (Entry<ProductType, HashMap<IStock, HashSet<Product>>> e1 : e.getValue().entrySet()) {
				for (Entry<IStock, HashSet<Product>> e2 : e1.getValue().entrySet()) {
					for (Product prod : e2.getValue()) {
						products.add(prod);
					}
				}
			}
		}
		
		Product nov = new Clothing("OPITEN", Brand.EVERLAST, Gender.MEN, 1500, "RABOTI LI", ClothType.JACKETS, "BLACK", "XL", 10);
		store.addToCatalog(nov);
		gosho.addToBag(nov, 4);
		System.out.println("Bag of Gosho before removal:");
		gosho.printUserBag();
		System.out.println("==========");
		gosho.returnProduct(nov);
		System.out.println("Bag of Gosho after removal:");
		gosho.printUserBag();
		System.out.println();
		gosho.purchaceAll();
		System.out.println("========= CATALOG AFTER PURCHASE =========");
		store.printCatalog();
		System.out.println("==========");
		System.out.println("Bag of Gosho after purchase:");
		gosho.printUserBag();
		System.out.println("==========");
		System.out.println("Bought list of Gosho after purchase:");
		gosho.printBoughtProducts();

		
	}

}
