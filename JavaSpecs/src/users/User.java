package users;

import store.Store;

public class User {
	
	private static int idNumber = 0;
	private String username;
	private String password;
	private String repeatPassword;
	private String email;
	private int id;
	private Store store;
	
	// for validation
	
		
	
	public User(String username, String password,String repeatPassword, String email, Store store) throws NullPointerException {
		
		this.store = store;
		// call the method to check if the specified mail already exists:
		
		if (emailAlreadyTaken(email)) {
			
			throw new NullPointerException();
		}
		else {
			this.email = email;
			
			
			this.username = username;
			this.password = password;
			this.email = email;
			this.id = idNumber;
			idNumber++;
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

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}
	
	

	
}
