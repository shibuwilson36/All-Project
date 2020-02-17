package com.testyantra.shoppingcart.util;

import com.testyantra.shopingcart.dao.ProductDao;
import com.testyantra.shopingcart.dao.ProductDaoImpl;

public class ProductManger {
	private ProductManger() {

	}
	public static ProductDao getInstance() {
		return new ProductDaoImpl() ;
	}
}
