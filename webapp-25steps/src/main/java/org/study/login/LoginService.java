package org.study.login;

public class LoginService {

	public boolean isUserValid(String user, String password) {
		if (password.equals("dummy")) {
			return true;
		}
		
		return false;
	}
}
