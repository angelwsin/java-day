package org.java.biz.pay;

public interface OrderMapper {
	
	
	public int  updateOrderStatus(Order order,OrderStatus toStatus);

}
