package org.study;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if (password.equals("dummy")) {
			return true;
		}
		
		return false;
	}
}
