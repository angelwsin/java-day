package org.java.biz.skill;

public class SKill {

	//数据加载缓存预热   削峰
	//减库存 放入队列   redis 库存挂了        userid hash到不同的队列服务
	//减库存成功   下订单   下订单服务挂了
	//db中的库存和redis中的库存 不同步  防止 超卖和少卖
	
	
}
