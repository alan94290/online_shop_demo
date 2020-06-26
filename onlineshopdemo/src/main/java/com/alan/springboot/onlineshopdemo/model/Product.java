package com.alan.springboot.onlineshopdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "seller")
	private String seller;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "price")
	private double price;

	@Column(name = "inventory")
	private int inventory;

	@Column(name = "detail")
	private String detail;

	public int getProductId() {
		return productId;
	}

	public Product(){}

	public Product(int productId, String seller, String productName, String productImage, double price, int inventory, String detail) {
		this.productId = productId;
		this.seller = seller;
		this.productName = productName;
		this.productImage = productImage;
		this.price = price;
		this.inventory = inventory;
		this.detail = detail;
	}

	public Product(String seller, String productName, String productImage, double price, int inventory, String detail) {
		this.seller = seller;
		this.productName = productName;
		this.productImage = productImage;
		this.price = price;
		this.inventory = inventory;
		this.detail = detail;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", seller='" + seller + '\'' +
				", productName='" + productName + '\'' +
				", productImage='" + productImage + '\'' +
				", price=" + price +
				", inventory=" + inventory +
				'}';
	}
}
