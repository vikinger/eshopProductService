package de.eshop.productservice;

/**
 * This class contains details about products.
 */

public class ProductSlim implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private double price;
	
	private int category;

	private String details;

	public ProductSlim() {
	}

	public ProductSlim(String name, double price, int category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public ProductSlim(String name, double price, int category, String details) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.details = details;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Integer getCategory() {
	return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
