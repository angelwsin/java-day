package org.java.distribute.acid;

public class DataBase {
    
    /*
     * 
     * 事务
     * 
     * 
     * 共享锁(读锁)
     * 排它锁(写锁)
     * 行级锁
     * 
     * 
     * 索引
     *  B-tree (聚合索引，辅助索引)
     *  Hash
     *  
     *  
     *  ACID
     *  
     *  A     事务保证原子性 (实现  redolog undolog)
     *  
     *  
     *  C    一致性
     *  
     *  I    隔离性                                                                                       增加并发性        MVCC
     *        读未提交         脏读           不可重复读  幻读
     *        读已提交        不可重复读  幻读
     *        可重复读        幻读
     *        序列化
     *  
     *  D   持久化
     *  
     *  
     *   数据库事务系统的核心挑战之一是并发控制协议
     *      多副本  MVCC
     * 
     */

}
