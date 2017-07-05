 Unix  一切 皆文件
 
 linux 操作系统 对文件的管理   fileDesc  fd   操作  open() read(),write(),close()
 
 //http://blog.csdn.net/hguisu/article/details/7445768/
 linux 网络  socket   sockfd
 
 
          server                                                                                   client
          
    int  socket(int protofamily, int type, int protocol);//返回sockfd   没有bind的
          
   int bind(int sockfd, const struct sockaddr *addr, socklen_t addrlen);-->bind sockfd
                                                                                            //通常服务器在启动的时候都会绑定一个众所周知的地址（如ip地址+端口号），用于提供服务，客户就可以通过它来接连服务器；而客户端就不用指定，有系统自动分配一个端口号和自身的ip地址组合。
                                                                                                                                                                                                                                                                                         这就是为什么通常服务器端在listen之前会调用bind()，而客户端就不会调用，而是在connect()时由系统随机生成一个。     
          //backlog 连接的最大队列
          int listen(int sockfd, int backlog); 等待客户端连接                                                                                                               int connect(int sockfd, const struct sockaddr *addr, socklen_t addrlen);
          
          
          //阻塞
  int accept(int sockfd, struct sockaddr *addr, socklen_t *addrlen); //返回连接connect_fd
  
    三次握手   tcp 抓包
  
                                                            
  |                                
  |
  |
  |
  |
  |
  |
  |
  
  
  
  
  
  
  
  
 read()、write()等函数
 
 close()
          
          