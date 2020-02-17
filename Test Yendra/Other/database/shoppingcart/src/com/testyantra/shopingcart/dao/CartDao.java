package com.testyantra.shopingcart.dao;

import java.util.ArrayList;

import com.testyantra.shopingcart.bean.CartBean;
import com.testyantra.shopingcart.bean.ProductBean;

public interface CartDao {
	public boolean addCart(CartBean bean);
	public ArrayList<ProductBean > getAllData();
}
