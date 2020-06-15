package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "description")
	private String discription;

	@Column(name = "price")
	private double price;

	@Column(name = "inventory_quantity")
	private int inventoryQuantity;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "tags")
	private String tags;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String productName, String discription, double price, int inventoryQuantity,
			String imageName, String imageUrl, String tags) {
		super();
		this.id = id;
		this.productName = productName;
		this.discription = discription;
		this.price = price;
		this.inventoryQuantity = inventoryQuantity;
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Product temp = (Product) obj;
		return Objects.equals(id, temp.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
