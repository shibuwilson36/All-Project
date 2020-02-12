package com.tyss.productrestapi.dao;

import java.util.List;

import com.tyss.productrestapi.dto.ProductInfoBean;

public interface ProductInfoDao {


	public boolean addProduct(ProductInfoBean bean);
	public boolean updateProduct(ProductInfoBean bean);
	public List<ProductInfoBean> getAllProduct();
	public List<ProductInfoBean> searchProduct(String name);
	public boolean deleteProduct(int id);

}
