package user;
public interface UserDAO{
	
	void registerUser(String username, String password);
	boolean loginUser(String username, String password);
}