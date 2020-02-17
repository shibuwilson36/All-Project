package com.testyantra.shoppingcart.util;

import com.testyantra.shopingcart.dao.CartDao;
import com.testyantra.shopingcart.dao.CartDaoImpl;

public class CartManger {
	private CartManger() {

	}
	public static CartDao getInstance() {
		return new CartDaoImpl();
	}
}
