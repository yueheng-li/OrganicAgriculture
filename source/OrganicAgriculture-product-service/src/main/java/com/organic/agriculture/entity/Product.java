package com.organic.agriculture.entity;

public class Product extends Entity {

	private String product_no;
	private String product_name;
	private double product_original_price;
	private double product_price;
	private String product_specifications;
	private String product_image_url;
	private String product_explain;
	private String product_descript;
	private String category;
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_original_price() {
		return product_original_price;
	}
	public void setProduct_original_price(double product_original_price) {
		this.product_original_price = product_original_price;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_specifications() {
		return product_specifications;
	}
	public void setProduct_specifications(String product_specifications) {
		this.product_specifications = product_specifications;
	}
	public String getProduct_image_url() {
		return product_image_url;
	}
	public void setProduct_image_url(String product_image_url) {
		this.product_image_url = product_image_url;
	}
	public String getProduct_explain() {
		return product_explain;
	}
	public void setProduct_explain(String product_explain) {
		this.product_explain = product_explain;
	}
	public String getProduct_descript() {
		return product_descript;
	}
	public void setProduct_descript(String product_descript) {
		this.product_descript = product_descript;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}