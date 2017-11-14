package org.java.biz.pay;

import java.math.BigDecimal;

public class BankOrder {
	
    private String orderNo;
	
	private BigDecimal  amount;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	

}
