package store;

import java.util.Comparator;

import users.User;

public class CompareByID implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getId() - o2.getId();
	}

	
	

}
