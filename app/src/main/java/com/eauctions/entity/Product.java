package com.eauctions.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productID;
	private String description;

	private double latitude;

	private String location;

	private double longitute;

	private String name;
	private List<Category> categories = new ArrayList<Category>();

	public Product() {
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getLongitute() {
		return this.longitute;
	}

	public void setLongitute(double longitute) {
		this.longitute = longitute;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public Category addCategory(Category category) {
		if(categories == null)
				this.categories = new ArrayList<Category>();
		getCategories().add(category);
		category.addProduct(this);
		return category;
	}
	
	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.removeProduct(null);
		return category;
	}

}
