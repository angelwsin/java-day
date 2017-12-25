package org.java.biz.skill;

import java.util.Objects;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisServiceImpl implements RedisService{
	
	
	static  JedisPool   jedisPool = new JedisPool("", 6379);

	@Override
	public boolean decr(String key, int limit, int off) {
		Jedis jedis  = jedisPool.getResource();
		String val =  jedis.get(key);
		if(Objects.isNull(val))
			return false;
		if(Integer.valueOf(val)<=limit)
			return false;
		if(jedis.decrBy(key, off)>limit){
			//处理秒杀成功的 发送扣库存的消息，(放入缓存队列中业务逻辑去拉)
		}
		return false;
	}

}
