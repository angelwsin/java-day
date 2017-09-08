package org.java.distribute.hystrix;

public class RpcServiceImpl implements RpcService{

    public RpcResponse call(RpcRequest request) {
       
          for(int i=0;i<1000;i++){
              System.out.println("00");
          }
        return new RpcResponse();
    }

}
