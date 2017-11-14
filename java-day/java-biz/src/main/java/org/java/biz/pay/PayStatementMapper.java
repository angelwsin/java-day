package org.java.biz.pay;

public interface PayStatementMapper {
	
	
	public void insertStaement(PayStatement st);
	public int  updateOrderStatus(PayStatement st,OrderStatus toStatus);

}
