package org.java.distribute.hystrix;

public interface RpcService {
    
    
    RpcResponse call(RpcRequest request);

}
