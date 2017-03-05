package store;


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
import shops.Product;
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
		
//		
		
		
//		try{
//			User pesho = new User("Petyr", "1234", "1234", "georgi@abv.bg", store);
//			store.addUser(pesho);
//		}
//		catch (NullPointerException e) {
//			System.out.println("This e-mail is already in the database. Please try with a different e-mail. ");
//		}
		
		System.out.println(store.getUsers().size());
		

		for (int i = 0; i < 50; i++) {
			Random r = new Random();
			int type = r.nextInt(3);
			if (type == 0) {
				store.addToCatalog(new FootWear("Air 2.0", Brand.ADIDAS, Gender.values()[r.nextInt(Gender.values().length)], r.nextDouble()*100 +20, "leather", ShoesType.values()[r.nextInt(ShoesType.values().length)]));
			}
			if (type == 1) {
				store.addToCatalog(new Accessories("Milestone", Brand.PUMA, Gender.values()[r.nextInt(Gender.values().length)], r.nextDouble()*100 +20, "Cool", AccessType.values()[r.nextInt(AccessType.values().length)]));
			}
			if (type == 2) {
				store.addToCatalog(new Clothing("Bluzka", Brand.EVERLAST, Gender.values()[r.nextInt(Gender.values().length)], r.nextDouble()*100 +20, "Pretty", ClothType.values()[r.nextInt(ClothType.values().length)]));
			}
		}
		
		
		store.printCatalog();
		System.out.println("============================");
		store.printFromPriceRange(10, 40);
		
	

	}

}
