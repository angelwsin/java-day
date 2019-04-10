public class 服务 {

    //分布式协议

    //传统 paxos        传统的是对提案进行投票 投票周期长复杂度高
     //后续的协议在此基础上进行了简化  分为选主和复制
    // zab  zookeeper  选主(使用提案)角色 leader follower brower和复制(二阶段)
    // Raft etcd       选主(自我推荐定时器)Follower，Candidate，Leader和复制(二阶段)

    //以上强一致性
    //以下最终一致性
    // Gossip Cassandra redis的哨兵模式选举master 去中心化、容错而又最终一致性的绝妙算法
}
