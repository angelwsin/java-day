package org.java.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;


/*
 * http://www.cnblogs.com/Anker/p/3265058.html
 * http://www.cnblogs.com/jeakeven/p/5435916.html
 */
public class Server {
    
    
    
    
    
    // select/poll
    
    
    public static void main(String[] args) throws Exception{
        
        Selector selector =  Selector.open();
        // selector.open 调用的就是
        //底层封装不同平台
        SelectorProvider.provider().openSelector();
        
        /*
         * SelectorProvider 封装了提供者  用于创建nio与 平台有关的对象
         * 
         * 查看 SelectorProviderImpl 类
         * 
         * SelectorProvider
         * 提供不同形式的 channel
         * UDP
         * TCP
         * Pipe
        */
        
        
        
        //服务端 
      //socketfd 创建
        ServerSocketChannel  channel =  ServerSocketChannel.open();//SelectorProvider.provider().openServerSocketChannel() 底层也是 使用 provider
        
        
        //bind sockfd
        channel.bind(new InetSocketAddress(3892));
        //listen
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);//SelectionKeyImpl 携带 channel selector ops  
                                                           // 并且 Selector 会维持一个 SelectionKeyImpl 列表
        //accept 阻塞等待连接
        selector.select();//阻塞
        //selector.selectNow() 和上一个方法不同的是 selectNow 非阻塞没有就绪的返回 0 
        
        Set<SelectionKey> keys  = selector.selectedKeys();
        
        Iterator<SelectionKey>  it = keys.iterator();
        
        SelectionKey selectiong = it.next();
        
        
        
        
        
        
    }
    
    
   //windows 下的实现   select/poll 的实现 
    
    //SelectThread 负责  subSelector.poll(index);  监听 事件  
    //有更新 则 更新 selectedKeys

}
