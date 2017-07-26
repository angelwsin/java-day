package org.java.jms;

/**
 * http://udn.yyuap.com/doc/JMS2CN/01_introduction/index.html
 * 
 * jms 规范
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        //JMS域
        /*
         * 1.点对点（Point-to-Point，PTP）消息风格允许一个客户端通过一个叫“队列（queue）”的中间抽象发送一个消息给另一个客户端。
         * 发送消息的客户端将一个消息发送到指定的队列中，接收消息的客户端从这个队列中抽取消息。
         * 1.发布订阅（Publish/Subscribe，Pub/Sub）消息风格则允许一个客户端通过一个叫“主题（topic）”的中间抽象发送一个消息给多个客户端。
         * 发送消息的客户端将一个消息发布到指定的主题中，然后这个消息将被投递到所有订阅了这个主题的客户端。
         */
        
        
        /**
         * JMS不包含如下功能： 负载均衡/容错：一些消息产品支持多个相互协作的客户端实现一个严格的业务。JMS API不具体指定这些客户端如何协作来完成某个单独统一的业务。
         * 错误/公告通知：很多消息产品定义了用于提供给客户端出错异步通知或系统事件的系统消息。JMS暂不考虑标准化这类消息。在本文下面的指引中可以看到，JMS客户端不使用这种消息因而避免了由此引入的移植性问题。 管理机制：JMS没有定义管理消息产品的API。
         * 安全：JMS没有制定控制消息隐私和完整性的API。同样也没有指定如何分发数字签名和密钥给客户端。安全问题应该作为JMS提供者特定的特性考虑，而不是由客户端的JMS API来控制。 传输协议（Wire Protocol）：JMS没有定义消息的传输格式协议。 消息类型仓库（Message Type
         * Repository）：JMS没有定义存储消息类型定义的仓库，而且也没有指定用于创建消息类型定义的语言。
         */
        
        
        /**
         * 如下的新消息特性是JMS2.0新增的： 延迟投递：消息生产者现在可以指定一个消息不立即投递而是在特定的时间间隔以后投递 新添加的发送方法运行应用异步的发送消息 JMS提供者现在必须设置JMSXDeliveryCount消息属性 如下变更是为了改进扩展性：
         * 持久订阅或非持久订阅现在可以是“共享的”，共享的订阅可以有多个消费者 以下的变更是为了简化JMS API的使用： Connection,Session和其他带有close()方法的对象现在实现了java.lang. AutoCloseable接口，这允许它们被用于Java
         * SE7的try-with-resources语句中 增加了一个新的简化API，相对于标准API更加简单，特别是用于Java EE应用的时候 添加了新的方法用于创建session，而无需提供过多的参数 虽然创建非共享持久订阅时Client ID还是必须的，但是现在创建共享持久订阅时Client
         * ID是可选的 一个名为getBody的新方法添加到Message，它允许直接从消息中抽取内容而不需要预先将其转换到一个子类型
         */
        
        /**
         * 什么是JMS应用 一个JMS应用由如下几个部分组成： JMS客户端-发送和接收消息的Java程序。 非JMS客户端-使用消息系统原生的客户端API代替JMS的客户端。如果程序早于JMS就可用，则它可能同时包含JMS客户端和非JMS客户端。
         * 消息-每个应用都定义了一组消息，用于多个客户端中间的消息通信。 消息提供者-实现了JMS的消息系统，作为一个完整的消息产品，它还应该提供其他的管理控制功能。 受管对象（Administrated Objects）-管理员创建、然后预先配置好给客户端使用的JMS对象。
         */
        
        /**
         * JMS受管对象分为两种： ConnectionFactory：客户端使用这个对象创建到提供者的连接 Destination：客户端使用这个对象来指定发送或接收消息的目的地 管理员可以在JNDI命名空间中配置这些受管对象。
         */
        
        
        /**
         * 不同API的通用接口 不同API的主要通用接口如下：
         *  Message，BytesMessage，MapMessage，ObjectMessage，StreamMessage和TextMessage：发送到JMS提供者或从JMS提供者接收的消息
         * Queue：为点对点消息处理封装了消息目的地标识的受管对象 
         * Topic： 为发布订阅消息处理封装了消息目的地标识的受管对象 
         * Destination：Queue和Topic的通用父类型
         */
        
        
        /**
         * 传统API接口 传统API提供的主要接口如下： ConnectionFactory：客户端用来创建连接的受管对象。简化API也会使用此接口。 Connection：客户端到JMS提供者之间的活动连接。 Session：发送和接收消息的一个单线程上下文。
         * MessageProducer：由Session创建的对象，用于发送消息到Queue或Topic MessageConsumer：由Session创建的对象，用于接收Queue或Topic中的消息
         */

        
        /**
         * 简化API接口 简化API与传统API提供的消息功能是一样的，但是它需要的接口更少、使用更方便。 简化API提供的主要接口如下： ConnectionFactory：客户端用来创建连接的受管对象。传统API也会使用此接口。
         * JMSContext：客户端到JMS提供者之间的活动连接，以及发送和接收消息的一个单线程上下文。 JMSProducer：由JMSContext创建的对象，用于发送消息到Queue或Topic JMSConsumer：由JMSContext创建的对象，用于接收Queue或Topic中的消息
         */
    }
}
