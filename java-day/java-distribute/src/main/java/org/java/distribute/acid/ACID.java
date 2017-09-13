package org.java.distribute.acid;

//http://www.cnblogs.com/nongchaoer/p/6476539.html
//http://blog.csdn.net/followmyinclinations/article/details/52870418
//http://jm.taobao.org/2012/11/19/mass-storage-16/
public class ACID {
    
    /**
     * 分布式 下的acid
     * 
     * 理论:
     * cap
     * base
     * 
     * 关于一致性:
     *  强一致性
     *  弱一致性
     *  最终一致性
     *  
     *  
     *  协议,理论:
     *  1)2pc
     *  2)3pc
     *  3)paxos (Chubby)
     *  和paxos协议相关:
     *  zookeeper(zab)  
     *  raft 
     * 
     *  
     *  
     *  分布式事务一致性:
     *  1)2pc  (单点，阻塞)
     *  2)同步写
     *  3)TCC
     *  4)借助消息中间件实现
     *  
     *  
     *  
     *  Zookeeper的ZAB，Viewstamped Replication（VR），raft，multi-paxos，这些都可以被称之为Leader-based一致性协议
     *  
     *  扩展协议:        实现者                              数据一致性 
     *  totem协议              pacemaker      强一致性
     *  gossip协议           Cassandra       最终一致性
     *  paxos                        强一致性
     *  
     *  
     *  
     *  
     *  
     *  
     *  
     *  2pc
     *  
     *   当引入无反馈
     *   
     *   1.死等
     *   2.数据不一致(脑裂)
     *   
     *   
     *   quorum机制-- 防止脑裂
     *   少数服从多数
     *   
     *   Paxos有没有什么值得改进的地方：
     *   如果在一个决议提议的过程中，其他决议会被否决，否决本身意味着更多的网络io，意味着更多的冲突，这些冲突都是需要额外的开销的，代价很大很大
     *   
     *   
     *   zab的改进 使用 领导者 实现  领导者处理所有的请求
     *   
     *   
     *  
     *         角色                                                           原理                       第一阶段                                                                第二阶段                      缺点
     *                  
     *  2pc   参与者，协调者                                      投票                      预提交(redolog,undolog)       提交阶段                      阻塞，脑裂，单点
     *  
     *  
     *  分布式考虑的问题：
     *  无反馈(线程挂起，网络断开)，挂掉(机器，进程，线程)
     *  
     *  第一阶段：     参与者 A,B
     *          A precommit   A完成          A阻塞等待B---------死等------可用性降低
     *                                                      
     *                                                  ------为了可用性等待超时时间认为B挂了------
     *                                                                             ------继续接受请求--         
     *                                                                                           ---此时出现数据不一致问题脑裂
     *          B precommit  ----------B没有返回--------- 
     *          
     *    
     *    
     *    为了解决死等问题 ,没有解决脑裂问题 3pc 问题的关键就是约定延迟某时间后，最终双方就按照某种”先期约定”进行后面的操作
     *    
     *    
     *         角色                                               原理          第一阶段                                                                             第二阶段                                                                第三阶段                      缺点
     *                  
     *  3pc   参与者，协调者                               投票         预提交(redolog,undolog)           prepare(canCommit)       提交阶段                     脑裂，单点
     *    
     *    
     *  
     *       
     * 
     *  
     * 
     *  
     *  
     *  
     *  
     *  
     *  
     *  
     */
    
    /*
     * Lease机制 Lease（租约）机制应用非常广泛：
     * 
     * 可用作授权来进行同步等操作(如Append) 可用作读锁/写锁（分布式锁） 租约的一个关键点就是有效期，过了有效期可以续约。如果不可用就收回租约，给另一台服务器权限。
     * 
     * 实际应用：
     * 
     * GFS: Master grant to ChunckServer 思考：Lease == Lock? Quorum机制 多数表决机制在分布式系统中通常有两个应用场景：
     * 
     * Leader Election Replication (NWR机制) 理论基础：鸽巢原理
     */
}
