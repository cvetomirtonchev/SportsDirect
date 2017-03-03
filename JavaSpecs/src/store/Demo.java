package store;

import users.User;
import users.User.InvalidEmailException;
import users.User.InvalidPasswordException;
import users.User.InvalidUsernameException;

public class Demo {
	
	public static void main(String[] args) throws InvalidEmailException, InvalidUsernameException, InvalidPasswordException {
		
		// testing new features
		
		Store store = new Store("Sofia");
		
		System.out.println(store.getUsers().isEmpty());
		
		try {
		User gosho = new User("Georgi", "1234", "1234", "georgi@abv.bg", store);
		store.addUser(gosho);
		}
		catch (NullPointerException e) {
			System.out.println("This e-mail is already in the database. Please try with a different e-mail. ");
		}
		
		try{
			User pesho = new User("Petyr", "1234", "1234", "georgi@abv.bg", store);
			store.addUser(pesho);
		}
		catch (NullPointerException e) {
			System.out.println("This e-mail is already in the database. Please try with a different e-mail. ");
		}
		
		System.out.println(store.getUsers().size());
	}

}
