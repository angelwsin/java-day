package org.java.biz.hong.bao;


//下单买红包-----支付---支付成功--红包推到群里--抢


public class HongBao {

	//包、发、抢、拆、查
	//包   生成红包单号---写红包订单---支付下单
	//发   支付---更新发红包订单---写发放记录---发微信消息
	//抢   查发红包订单
	//拆   查发红包订单---计算红包金额---写领取订单---更新发红包订单---写领取记录---转零钱---更新领取单
	
	/*如果把拆红包过程，类比为一个秒杀活动的过程，相当于扣库存与写入秒杀记录的过程。更新库存对应于更新红包发送订单，
	写入秒杀记录对应于写入这个红包的领取红包记录。另外，还要写入用户整体的红包领取记录。最后请求微信支付系统给拆到红包用户转入零钱，
	成功后更新抢红包的订单状态为已转账成功。*/
	
	//微信红包系统采取按时间做冷热数据分离，降低数据的存储成本，同时提升了热数据的访问性能
	
	/*
	 * 
	 *             统一接入层
	 *             业务处理层 
	 *             数据层
	 *             对账，审计
	 */
	
	/*
	 * 业务逻辑层 - 异步化设计
	 * 
	 */
	//SET 化指订单 DB 和订单接入 SERVER 垂直 stick 一起。
	//业务逻辑层访问订单时，根据订单倒数第二、三位数字找到所属订单 SET，一个 SET 的请求不能路由到其他 SET
	//通过 SET 化得到的好处是，控制 DB 连接数、隔离故障影响和分流并发
	
	
	/*
	 * 即使 DB 出现故障，业务的可用性也不会有影响。这里还有一点，新的发红包请求可避免 DB 故障的影响，但那些故障之前已发出未被领取的红包，
	 * 红包消息已发送到微信群，单号已确定，拆红包时还是失败。对这种情况，由于不会有增量，采用正常的主备切换解决即可。
	 */
	
	//方案一，使用内存操作替代实时的DB事务操作
	//方案二，使用乐观锁替代悲观锁。
	/*1.如果拆红包采用乐观锁，那么在并发抢到相同版本号的拆红包请求中，只有一个能拆红包成功，其他的请求将事务回滚并返回失败，给用户报错，用户体验完全不可接受。
	  2.如果采用乐观锁，将会导致第一时间同时拆红包的用户有一部分直接返回失败，反而那些“手慢”的用户，有可能因为并发减小后拆红包成功，这会带来用户体验上的负面影响。
	  3.如果采用乐观锁的方式，会带来大数量的无效更新请求、事务回滚，给DB造成不必要的额外压力*/
	
}
