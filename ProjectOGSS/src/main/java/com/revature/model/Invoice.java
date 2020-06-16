package com.revature.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.revature.struct.Token;

@Entity
@Table(name = "orders_invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "shipping_date")
	private String shippingDate;

	@Column(name = "purchase_date")
	private String purchaseDate;

	@Column(name = "sub_total")
	private BigDecimal subTotal;

	@Column(name = "tax")
	private BigDecimal tax;

	@Column(name = "discount_code")
	private String discountCode;

	@Column(name = "delivery_charge")
	private BigDecimal deliveryCharge;

	@Column(name = "final_price")
	private BigDecimal finalPrice;

	@Column(name = "status")
	private String status;

	@Column(name = "customer_comments")
	private String customerComments;

	@Column(name = "delivery_comments")
	private String deliveryComments;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "card_number")
	private String cardNumber;

	@OneToOne
	@JoinColumn(name = "driver_id")
	private UserAccount driver;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private UserAccount customer;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<ItemList> itemList = new ArrayList<ItemList>();

	@Transient
	private Token token;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public BigDecimal getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(BigDecimal deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerComments() {
		return customerComments;
	}

	public void setCustomerComments(String customerComments) {
		this.customerComments = customerComments;
	}

	public String getDeliveryComments() {
		return deliveryComments;
	}

	public void setDeliveryComments(String deliveryComments) {
		this.deliveryComments = deliveryComments;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public UserAccount getDriver() {
		return driver;
	}

	public void setDriver(UserAccount driver) {
		this.driver = driver;
	}

	public UserAccount getCustomer() {
		return customer;
	}

	public void setCustomer(UserAccount customer) {
		this.customer = customer;
	}

	public List<ItemList> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemList> itemList) {
		this.itemList = itemList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Invoice temp = (Invoice) obj;
		return Objects.equals(id, temp.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

}
