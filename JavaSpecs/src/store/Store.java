package store;

import java.util.Collections;
import java.util.TreeSet;

import users.User;

public class Store {
	
	private String name = "Sports Direct";
	private String address;
	private TreeSet<User> users = new TreeSet<>(new CompareByID());
	
	
	
	
	public TreeSet<User> getUsers() {
		return (TreeSet<User>) Collections.unmodifiableSet(this.users);
	}

}
