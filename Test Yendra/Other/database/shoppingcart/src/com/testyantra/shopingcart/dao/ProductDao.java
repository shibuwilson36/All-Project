package com.testyantra.shopingcart.dao;

import java.util.ArrayList;

import com.testyantra.shopingcart.bean.ProductBean;

public interface ProductDao {
	public boolean addProduct(ProductBean bean);
	public ProductBean searchEmpId(int id);
	public ArrayList<ProductBean > getAllData();
}
