package org.java.nio.selector;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class SelectorX {
    public static void main(String[] args)throws Exception {
        Selector selector =  Selector.open();
        // selector.open 调用的就是
        //底层封装不同平台
        SelectorProvider.provider().openSelector();
        
        /*
         * SelectorProvider 封装了提供者  用于创建nio与 平台有关的对象
         */
        
        SocketChannel  server = SocketChannel.open(); //初始化  fd
        server.configureBlocking(true);
        server.bind(new InetSocketAddress(1923));
        server.register(selector, SelectionKey.OP_ACCEPT);
        
          selector.select();
         // selector.select(timeout)
          //non-blocking selection operation then this method immediately returns zero
          //selector.selectNow()
    }
    
    /*SelectorProvider
     * ----Selector
     *                   SelectionKey 
     * ----SocketChannel
     * 
     */
}
