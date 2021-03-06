package com.tyss.productrestapi.service;

import java.util.List;

import com.tyss.productrestapi.dto.ProductInfoBean;

public interface ProductService {
	public boolean addProduct(ProductInfoBean bean);
	public boolean updateProduct(ProductInfoBean bean);
	public List<ProductInfoBean> getAllProduct();
	public List<ProductInfoBean> searchProduct(String name);
	public boolean deleteProduct(int id);
}
