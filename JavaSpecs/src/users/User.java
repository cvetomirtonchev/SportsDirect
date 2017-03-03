package users;

import java.util.ArrayList;

import shops.Product;
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
	
	// for validation
	
		
	
	public User(String username, String password,String repeatPassword, 
			String email, Store store) throws InvalidEmailException, InvalidUsernameException, InvalidPasswordException{ 
		this.store = store;
		// call the method to check if the specified mail already exists:
		
		if (emailAlreadyTaken(email)) {
			
			throw new InvalidEmailException("Exist user with this e-mail");
		}
		else {
			this.email = email;
		if(!username.isEmpty()&&!username.equals("")&&username.length()>=4){
			this.username = username;
		}
		else{
			throw new InvalidUsernameException("The username must be 4 or more symbols ");
		}
		// password must contain 1 big word,1 symbol and be over 6 sumbols
		String[] passcode = password.split("");
		String golemibukvi = "QWERTYUIOPASDFGHJKLZXCVN";
		String[] bukvi = golemibukvi.split("");
		String simvoli = "!@#$%^&*()_+{}:|<>?123456789";
		String[] simbols = simvoli.split("");
		if (!password.equals(" ")) {
			if (password.length() > 5) {
				for (int i = 0; i < passcode.length; i++) {
					for (int j = 0; j < bukvi.length; j++) {
						if (passcode[i].equals(bukvi[j])) {
							for (int j2 = 0; j2 < passcode.length; j2++) {
								for (int k = 0; k < simbols.length; k++) {
									if (passcode[j2].equals(simbols[k])) {
										this.password = password;
									}

								}

							}
						}

					}

				}

			}

		} else {
		
			throw new InvalidPasswordException("password must contain 1 big word,1 symbol and be over 6 sumbols" );

		}
		if(password.equals(repeatPassword)){
			this.password = repeatPassword;
		}
		else{
			throw new InvalidPasswordException("passwords doesn't match");
		}
		
			this.email = email;
			this.id = idNumber;
			idNumber++;
			this.shoppingBag = new ArrayList<>();
		}
	}
	
	// checks if an e-mail is already taken
	private boolean emailAlreadyTaken (String mail) {
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
	
	//TODO add to bag method
	
//	public void addToBag (Product product, String color, String size, int quantity) {
//		Product prod = 
//		
//	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}
	
	

	
}
