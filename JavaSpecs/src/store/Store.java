package store;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

import users.User;

public class Store {
	
	private String name = "Sports Direct";
	private String address;
	private TreeSet<User> users;
		
	public Store(String address) {
		this.address = address;
		this.users = new TreeSet<>(new CompareByID());
	}

	public Collection<User> getUsers() {
		
		return Collections.unmodifiableCollection(users);
	}
	
	public void addUser (User u) {
		if (u != null) {
			users.add(u);
		}
	}

}
