package com.testyantra.shoppingcart.util;

import com.testyantra.shopingcart.dao.CartDao;
import com.testyantra.shopingcart.dao.CartDaoImpl;
import com.testyantra.shopingcart.dao.WishListDao;
import com.testyantra.shopingcart.dao.WishListDaoImpl;

public class WishListManger {
	private WishListManger() {

	}
	public static WishListDao getInstance() {
		return new WishListDaoImpl();
	}
}
