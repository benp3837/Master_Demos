package com.revature.factory;

//All objects that implement Cookie will have access to the getBaked method.
//We'll use the CookieFactory to write logic that creates objects of type Cookie.

public interface Cookie {

	//all implementing Classes will have their own version of this method (overriding!!)
	public void getBaked();
	
}
