package com.pradipta.jee;

public class UserValidation {
	public boolean isUserValid(String user, String pass)
	{
		if(user.equals("pradipta")&& pass.equals("12345"))
			return true;
		return false;
	}
}
