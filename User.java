package sait.sll.problemdomain;

import java.io.Serializable;

/**
 * Represents a user.
 * @version 2025
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String name;
	
	private String email;
	
	private transient String password;
	
	/**
	 * Creates a User object with specified arguments.
	 * @param id user ID.
	 * @param name user name.
	 * @param email user e-mail address.
	 * @param password user password.
	 */
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Gets the user ID.
	 * @return user ID.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets the user name.
	 * @return user name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the user email address.
	 * @return e-mail address.
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Checks if the passed password is correct.
	 * @param password password to check.
	 * @return true if password is correct, false otherwise.
	 */
	public boolean isCorrectPassword(String password) {
		if (this.password == null && password == null)
			return true;
		else if (this.password == null || password == null)
			return false;
		else
			return this.password.equals(password);
	}
	
	/**
	 * Checks if object is equal to another object.
	 * @param obj the object to compare to.
	 * @return true if the objects are equal, false otherwise.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof User))
			return false;
		
		User other = (User) obj;
		
		return this.id == other.id && this.name.equals(other.name) && this.email.equals(other.email);
	}
}
