package com.testyantra.shopingcart.bean;

public class ProductBean {
	
	private  int productId;
	private String productName;
	private String brand;
	private  double price; 
	private  double quntity; 
	private String image;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuntity() {
		return quntity;
	}
	public void setQuntity(double quntity) {
		this.quntity = quntity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
