package com.eauctions.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	private int categoryID;

	private String name;
	private List<Product> products ;

	public Category() {
	}

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Product addProduct(Product p) {
		if(products == null)
				this.products = new ArrayList<Product>();
		getProducts().add(p);
		return p;
	}
	
	public Product removeProduct(Product p) {
		getProducts().remove(p);
		return p;
	}

}
