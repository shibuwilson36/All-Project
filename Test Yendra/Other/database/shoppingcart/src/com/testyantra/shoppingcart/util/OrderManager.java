package com.testyantra.shoppingcart.util;

import com.testyantra.shopingcart.dao.OrderDao;
import com.testyantra.shopingcart.dao.OrderDaoImpl;

public class OrderManager {
	private OrderManager() {

	}
	public static OrderDao getInstant() {
		return new OrderDaoImpl();
	}
}
