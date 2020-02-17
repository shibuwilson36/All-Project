package com.testyantra.shoppingcart.util;

import com.testyantra.shopingcart.dao.CartDao;
import com.testyantra.shopingcart.dao.CartDaoImpl;
import com.testyantra.shopingcart.dao.UserDao;
import com.testyantra.shopingcart.dao.UserDaoImpl;
import com.testyantra.shopingcart.dao.WishListDao;
import com.testyantra.shopingcart.dao.WishListDaoImpl;

public class UserManger {
	private UserManger() {

	}
	public static UserDao getInstance() {
		return new UserDaoImpl();
	}
}
