package org.java.serialize;


import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Date;

/*

  各种序列化的对比
  https://blog.csdn.net/flyingnet/article/details/79884660  对比

 */
public class VS {


    public static void main(String[] args){


        User user = new User();
        user.setUserName("zhangsan");
        user.setPassword("9093043");
        user.setPrices(new BigDecimal("0.9999"));
        user.setBirth(new Date());
        long start = 0;

        //java 自身的序列化
        //173 bytes
        try(ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            ObjectOutputStream o = new ObjectOutputStream(out);
            start = System.currentTimeMillis();
            o.writeObject(user);
            System.out.println(System.currentTimeMillis()-start);
            System.out.println(out.toByteArray().length);
        } catch (Exception e) {

        }

        // hessian 83bytes
        //Mt org.java.serialize.UserS userNameS zhangsanS passwordS 9093043S userNameNz
        //hessian 的序列化原理类似key value
        //问题：
        //1)父类中和子类属性一致 父类会覆盖子类中的属性
        //2)枚举类型的问题  序列化使用name 反序列化使用Enum.valueOf() 客户端和服务端同时更新，还有ordinal值问题
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();){
            HessianOutput output = new HessianOutput(out);
            start = System.currentTimeMillis();
            output.writeObject(user);
            output.close();
            System.out.println(System.currentTimeMillis()-start);
            System.out.println(out.toByteArray().length);
            HessianInput iput = new HessianInput(new ByteArrayInputStream(out.toByteArray()));
            User ux = (User) iput.readObject();
            System.out.println(ux.getBirth());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //hessina2  72bytes
        try (ByteArrayOutputStream outx = new ByteArrayOutputStream();){
            Hessian2Output output = new Hessian2Output(outx);
            start = System.currentTimeMillis();
            output.writeObject(user);
            output.close();
            //System.out.println(System.currentTimeMillis()-start);
            System.out.println(outx.toByteArray().length);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // vs 空间上的对比 java 自身序列化 几乎是 hessian 序列化所占空间的两倍


    }
}
