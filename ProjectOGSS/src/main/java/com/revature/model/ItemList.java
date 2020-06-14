package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "item_list")
public class ItemList {

	@EmbeddedId
	private ItemListID id;

	@ManyToOne
	@MapsId("orderID")
	private Invoice order;

	@ManyToOne
	@MapsId("productID")
	private Product product;

	@Column(name = "quantity")
	private int quantity;

	public ItemList() {
		super();
		// TODO Auto-generated constructor stub
		this.id = new ItemListID();
	}

	public ItemList(Invoice order, Product product) {
		this.order = order;
		this.product = product;
		this.id = new ItemListID();
	}

	public ItemListID getId() {
		return id;
	}

	public void setId(ItemListID id) {
		this.id = id;
	}

	public Invoice getOrder() {
		return order;
	}

	public void setOrder(Invoice order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		ItemList temp = (ItemList) obj;
		return Objects.equals(order, temp.order) && Objects.equals(product, temp.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
}
