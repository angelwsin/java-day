package org.java.utils.pool.commons;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;

public class JedisFactory implements PooledObjectFactory<Jedis> {



    //创建一个对象
    @Override
    public PooledObject<Jedis> makeObject() throws Exception {
        return null;
    }


    @Override
    public void destroyObject(PooledObject<Jedis> pooledObject) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<Jedis> pooledObject) {
        return false;
    }

    @Override
    public void activateObject(PooledObject<Jedis> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<Jedis> pooledObject) throws Exception {

    }
}
