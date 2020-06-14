package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemListID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865041278577210149L;

	@Column(name = "order_id")
	private int orderID;
	@Column(name = "product_id")
	private int productID;

	public ItemListID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemListID(int orderID, int productID) {
		super();
		this.orderID = orderID;
		this.productID = productID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		ItemListID temp = (ItemListID) obj;
		return Objects.equals(orderID, temp.orderID) && Objects.equals(productID, temp.productID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderID, productID);
	}

}
