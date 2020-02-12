package com.tyss.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springboot.dao.ProductInfoDao;
import com.tyss.springboot.dto.ProductInfoBean;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductInfoDao dao;

	@Override
	public boolean addProduct(ProductInfoBean bean) {
		
		return dao.addProduct(bean);
	}

	@Override
	public boolean updateProduct(ProductInfoBean bean) {
		
		return dao.updateProduct(bean);
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		
		return dao.getAllProduct();
	}

	@Override
	public List<ProductInfoBean> searchProduct(String name) {
		
		return dao.searchProduct(name);
	}

	@Override
	public boolean deleteProduct(int id) {
		
		return dao.deleteProduct(id);
	}

}
