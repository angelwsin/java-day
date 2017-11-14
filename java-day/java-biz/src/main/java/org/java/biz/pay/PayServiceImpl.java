package org.java.biz.pay;

public class PayServiceImpl implements PayService{

	private OrderMapper        orderMapper;
	
	private BankService        bankService;
	
	private PayStatementMapper payStatementMapper;
	//1.事务范围要小
	//2.加锁
	//3.幂等
	public void pay(Order order) {
		// 单库更新状态
		int count = orderMapper.updateOrderStatus(order, OrderStatus.processing);
		if(count>0){
			//幂等  这里有个流水
			PayStatement st = new PayStatement();
			st.setOrderNo(order.getOrderNo());
			st.setStatementStatus(OrderStatus.processing);
			payStatementMapper.insertStaement(st);
			BankOrder bankOrder = new BankOrder();
			bankOrder.setAmount(order.getAmount());
			bankOrder.setOrderNo(st.getStatementNo());
			try {
			 boolean stat = bankService.pay(bankOrder);
			 //以下更新加入到同一事务中
			 orderMapper.updateOrderStatus(order, stat?OrderStatus.sucess:OrderStatus.fail);
			 payStatementMapper.updateOrderStatus(st, stat?OrderStatus.sucess:OrderStatus.fail);
			} catch (Exception e) {
			  
			}
		}
	}

}
