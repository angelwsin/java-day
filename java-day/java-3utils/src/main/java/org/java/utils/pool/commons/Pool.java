package org.java.utils.pool.commons;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.NoSuchElementException;

public abstract  class Pool<T> {

    GenericObjectPool<T> internalPool;


    public Pool(PooledObjectFactory<T> factory, GenericObjectPoolConfig<T> poolConfig){

         internalPool = new GenericObjectPool<T>(factory, poolConfig);

    }


     //////从对象池中借出对象
    //T borrowObject() throws Exception, NoSuchElementException, IllegalStateException;


    //将对象归还到对象池中
   // void returnObject(T var1) throws Exception;

    //使一个对象无效
    // void invalidateObject(T var1) throws Exception;

    //向对象池中添加对象
    //void addObject() throws Exception, IllegalStateException, UnsupportedOperationException;

    //得到当前对象池中空闲的对象
    // int getNumIdle();

    //得到当前对象池已经借出的对象，这里的激活其实就是对象池借出对象的概念
    // int getNumActive();

    //清空对象池，并销毁对象池中的所有对象
    // void clear() throws Exception, UnsupportedOperationException;

    // 关闭对象池
    // void close();
}
