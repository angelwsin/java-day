package org.java.biz.pay;

public class PayStatement {
	
	
	private String orderNo;
	
	private String statementNo;
	
	private OrderStatus statementStatus;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getStatementNo() {
		return statementNo;
	}

	public void setStatementNo(String statementNo) {
		this.statementNo = statementNo;
	}

	public OrderStatus getStatementStatus() {
		return statementStatus;
	}

	public void setStatementStatus(OrderStatus statementStatus) {
		this.statementStatus = statementStatus;
	}

	
	

}
