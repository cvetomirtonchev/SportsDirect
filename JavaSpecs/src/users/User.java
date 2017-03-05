package users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

import shops.Product;
import shops.Product.Gender;
import shops.Product.ProductType;
import store.IStock;
import store.Store;

public class User {
	public class InvalidUsernameException extends Exception {
		public InvalidUsernameException(String msg) {
			super(msg);
		}
	}

	public class InvalidEmailException extends Exception {

		public InvalidEmailException(String msg) {
			super(msg);
		}
	}

	public class InvalidPasswordException extends Exception {
		public InvalidPasswordException(String msg) {
			super(msg);
		}
	}

	private static int idNumber = 0;
	private String username;
	private String password;
	private String repeatPassword;
	private String email;
	private int id;
	private Store store;
	private ArrayList<Product> shoppingBag;
	private ArrayList<String> prodColor;
	private ArrayList<String> prodSize;
	private ArrayList<Integer> prodQuantity;
	// for user menu
	private ArrayList<Product> boughtProducts;

	// for validation

	public User(String username, String password, String repeatPassword, String email, Store store)
			throws InvalidEmailException, InvalidUsernameException, InvalidPasswordException {
		this.store = store;

		if (emailAlreadyTaken(email)) {

			throw new InvalidEmailException("Exist user with this e-mail");
		} else {
			this.email = email;
			if (!username.isEmpty() && !username.equals("") && username.length() >= 4) {
				this.username = username;
			} else {
				throw new InvalidUsernameException("The username must be 4 or more symbols ");
			}
			if (checkPass(password)) {
				this.password = password;

			} else {
				throw new InvalidPasswordException("password must contain 1 big word,1 symbol and be over 6 sumbols");

			}
			if (password.equals(repeatPassword)) {
				this.password = repeatPassword;
			} else {
				throw new InvalidPasswordException("passwords doesn't match");
			}

			this.email = email;
			this.id = idNumber;
			idNumber++;
			this.boughtProducts = new ArrayList<>();
			this.shoppingBag = new ArrayList<>();
			this.prodColor = new ArrayList<>();
			this.prodQuantity = new ArrayList<>();
			this.prodSize = new ArrayList<>();

		}
	}

	private boolean emailAlreadyTaken(String mail) {
		boolean isTaken = false;
		if (!this.store.getUsers().isEmpty()) {
			for (User u : this.store.getUsers()) {
				if (mail.equals(u.getEmail())) {
					isTaken = true;
					break;
				}
			}
		}
		return isTaken;
	}
	
	public void printUserBag () {
		if (!this.shoppingBag.isEmpty()) {
			System.out.println("Shopping Bag");
			for (int i = 0; i < this.shoppingBag.size(); i++) {
				System.out.println("Name: " + this.shoppingBag.get(i).getName() + ", color: " + this.prodColor.get(i) + ", size: " + 
							this.prodSize.get(i) + ", quantity: " + this.prodQuantity.get(i) + ", price: " + this.shoppingBag.get(i).getPrice());
			}
		}
		else {
			System.out.println("Bag is empty!");
		}
	}

	public void addToBag(Product product, String color, String size, int quantity) {
		if (this.store.checkAvailability(product, color, size, quantity)) {
			this.shoppingBag.add(product);
			this.prodColor.add(color);
			this.prodQuantity.add(quantity);
			this.prodSize.add(size);
		}
	}

	public void returnProduct(Product product) {
		if (this.shoppingBag.contains(product)) {
			for (int i = 0; i < this.shoppingBag.size(); i++) {
				this.prodColor.remove(this.shoppingBag.indexOf(product));
				this.prodSize.remove(this.shoppingBag.indexOf(product));
				this.prodQuantity.remove(this.shoppingBag.indexOf(product));
				this.shoppingBag.remove(product);
			}
		}
	}

	public void purchaceAll() {
		if (!this.shoppingBag.isEmpty()) {
			for (int i = 0; i < this.shoppingBag.size(); i++) {
				this.store.removeFromCatalog(this.shoppingBag.get(i), this.prodColor.get(i), this.prodSize.get(i), this.prodQuantity.get(i));
				this.boughtProducts.add(this.shoppingBag.get(i));
			}
			this.shoppingBag.clear();
			this.prodColor.clear();
			this.prodQuantity.clear();
			this.prodSize.clear();
		}
	}

	private boolean checkPass(String pass) {
		boolean hasCapital = false;
		boolean hasSmall = false;
		boolean hasSymbol = false;

		for (int i = 0; i < pass.length(); i++) {
			if (pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z') {
				hasSmall = true;
			}
			if (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z') {
				hasCapital = true;
			}
			if (!(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z')
					&& !(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z')) {
				hasSymbol = true;
			}

		}
		if (hasCapital && hasSmall && hasSymbol) {
			return true;
		}
		return false;

	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public Store getStore() {
		return store;
	}
	
	

}
