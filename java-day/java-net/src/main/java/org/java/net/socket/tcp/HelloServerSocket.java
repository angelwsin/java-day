package org.java.net.socket.tcp;

import java.net.ServerSocket;
import java.net.Socket;

//http://blog.csdn.net/blueman2012/article/details/6693605
public class HelloServerSocket {
	
	public static void main(String[] args) {
		/*backlog:The maximum queue length for incoming connection indications (a
			     * request to connect) is set to the {@code backlog} parameter. If
			     * a connection indication arrives when the queue is full, the
			     * connection is refused.*/
		//ServerSocket 封装了bsd 中的三步:1)socket 2)bind 3)listen
		try(ServerSocket server = new ServerSocket(5089, 1024);) {
			for(;;){
				//阻塞等待客户端接入，创建socket并从连接队列中移除,此时三次握手已经完成
			 Socket socket = server.accept();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//伯克利套接字（BSD Socket）
	
	//1) socket() 创造某种类型的套接字，分配一些系统资源，用返回的整数识别Fd。                        java.net.SocketImpl.create(boolean)
	//2) bind() 一般是用在服务器这边，和一个套接字地址结构相连，比如说是一个特定的本地端口号和一个IP地址。   java.net.SocketImpl.bind(InetAddress, int)
	//3) listen()用在服务器一边，导致一个绑定的TCP套接字进入监听状态。                       java.net.SocketImpl.listen(int)
	//4) accept() 用在服务器这边。从客户机那接受请求试图创造一个新的TCP连接，并把一个套接字和这个连接相联系起来。
	//send() and recv(), or write() and read(), or sendto() and recvfrom()用来接收和发送数据。
	//close() 关闭连接，系统释放资源。
	//gethostbyname() and gethostbyaddr()用来解析主机名和地址。
	//select() is used to prune a provided list of sockets for those that are ready to read, ready to write, or that have errors.
	//poll() is used to check on the state of a socket in a set of sockets. The set can be tested to see if any socket can be written to, read from or if an error occurred.
	//getsockopt() is used to retrieve the current value of a particular socket option for the specified socket.
	//setsockopt() is used to set a particular socket option for the specified socket.
	
	
	
	
	
	
	
	
	
	/*
	 * 1)socket() socket() 为通信创造一个端点并返回一个文件描述符。 socket() 由三个参数： domain,
	 * 确定协议族。例如： PF_INET 是IPv4 或者 PF_INET6 是 IPv6. PF_UNIX 是本地(用一个文件). type,
	 * 是下面中的一个: SOCK_STREAM (可靠的面向连接的服务或者 Stream Sockets) SOCK_DGRAM (数据包服务或者
	 * Datagram Sockets) SOCK_SEQPACKET (可靠的有序的分组服务),或者 SOCK_RAW (网络层的原始协议)。
	 * protocol 确定实际使用的运输层。最常见的是 IPPROTO_TCP, IPPROTO_SCTP, IPPROTO_UDP,
	 * IPPROTO_DCCP。这些协议是在<netinet/in.h>中定义的。如果 domain 和 type已经确定，“0”
	 * 可以用来选择一个默认的协议。 如果出错返回-1，否则返回一个代表文件描述符的整数。 函数原型 int socket(int domain, int
	 * type, int protocol);
	 * 
	 * 2)bind() bind() 给套接字分配一个地址。当使用 socket()创造一个套接字时,
	 * 只是给定了协议族,并没有分配地址。在套接字能够接受来自其他主机的连接前，必须用bind()给它绑定一个地址。 bind() 由三个参数：
	 * sockfd, 代表socket的文件描述符。 my_addr, 指向 sockaddr 结构体的指针，代表要绑定的地址 。 addrlen,
	 * 是sockaddr结构体的大小。 Bind()返回0表示成功，错误返回-1。 函数原型 int bind(int sockfd, const
	 * struct sockaddr *my_addr, socklen_t addrlen);
	 * 
	 * 3)listen()
	 * 
	 * 一旦一个套接字和一个地址联系之后，listen() 监听到来的连接。但是这只适用于对面向连接的模式，例如 套接字类型是 (SOCK_STREAM,
	 * SOCK_SEQPACKET)。listen()需要两个参数： sockfd,一个有效的套接字描述符。
	 * backlog,一个整数，表示一次能够等待的最大连接数目。操作系统通常会对这个值设置上限。 一旦连接被接受，返回0表示成功，错误返回-1。
	 * 函数原型： int listen(int sockfd, int backlog);
	 * 
	 * 
	 * 4)accept()
	 * 
	 * 当应用程序监听来自其他主机的面对数据流的连接时，通过事件（比如Unix select()系统调用）通知它。必须用 accept()函数初始化连接。
	 * Accept() 为每个连接创立新的套接字并从监听队列中移除这个连接。它使用如下参数： sockfd,监听的套接字描述符 cliaddr,
	 * 指向sockaddr 结构体的指针，客户机地址信息。 addrlen,指向 socklen_t的指针，确定客户机地址结构体的大小 。
	 * 返回新的套接字描述符，出错返回-1。进一步的通信必须通过这个套接字。 Datagram
	 * 套接字不要求用accept()处理，因为接收方可能用监听套接字立即处理这个请求。
	 *  函数原型： int accept(int sockfd,struct sockaddr *cliaddr, socklen_t *addrlen);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/*
	 * read writer这里涉及到系统调用  多次拷贝
	 * 可以看linux零拷贝
	 * http://blog.csdn.net/zuijinhaoma8/article/details/47858223
	 */

}
