package users;

public class User {
	
	private static int idNumber=0;
	private String username;
	private String password;
	private String repeatPassword;
	private String email;
	
	
	
	public User(String username, String password,String repeatPassword, String email) {
		super();
		this.username = username;
		this.password = password;
		
		this.email = email;
	}
	
	
}
