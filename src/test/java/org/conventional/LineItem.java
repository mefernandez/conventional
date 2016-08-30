package org.conventional;

import java.math.BigDecimal;

public class LineItem {
	
	private int quantity;
	private BigDecimal price;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


}
