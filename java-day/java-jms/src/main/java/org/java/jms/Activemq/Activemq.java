package org.java.jms.Activemq;


// activemy 集群搭建  http://www.cnblogs.com/shihaiming/p/6018916.html

/**
 * 
 * MASTER/SLAVE模式
 *  Cluster模式
 *
 */
public class Activemq {
    
    
    
    
    /**
     * Activemq 实现了 jms 规范
     * 
     * 
     * 
     * brokerService（公共组件） broker 启动组件 主要 配置的解析和启动工作
     * 
     * 初始化配置 --可用内存初始化 SystemUsage
     * 
     * -- 连接器初始化 Connector transportConnector
     * 
     * 启动组件
     * 
     * --内存管理 组件
     * 
     * --broker 组件 使用 链式模式 组装
     * 
     * ConnectionSplitBroker UserIDBroker TransactionBroker CompositeDestinationBroker(pre-fetch 优化) AdvisoryBroker ManagedRegionBroker 
     *                                                                                                                               -------QueueRegion
     *                                                                                                                               -------TopicRegion
     * 
     * --Connector 组件 根据协议启动 配置加载使用 ServiceLoader
     * 
     * 服务端启动
     * 
     * 
     * 启动 所有连接 TransportConnector (tcp--TcpTransportFactory,stomp)
     *
     * 
     * 模式Reactor和Proactor模式
     *
     * 大量的异步回调
     * 
     * tcp 协议处理为例 Reactor模式
     * 
     * Accept线程 socket 放入阻塞队列
     * 
     * socketHandlerThread 从队列中拿去 连接的 socket 封装成TcpTransport 
     * 异步回调 AcceptListener 初始化 TcpTransport 异步回调 处理 i/o 请求 启动
     * TcpTransport 处理守护线程（每一个客户端的接入就会启动一个 可以优化）
     * 
     * 两种 Connection 工厂
     * 
     * ActiveMQXAConnectionFactory ActiveMQConnectionFactory
     * 
     * i/o 请求的消息 使用 commd接口统一
     * 
     * 消息类型
     * 
     * 
     *
     * 
     * 
     * 
     * 初始化 工具
     * 
     * --DestinationFactory 
     * --DestinationStatistics 统计组件
     * 
     * jmx 监控
     * 
     * HealthViewMBean
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
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */

}
