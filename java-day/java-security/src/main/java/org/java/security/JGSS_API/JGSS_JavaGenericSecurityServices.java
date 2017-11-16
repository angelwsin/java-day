package org.java.security.JGSS_API;

import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

//https://docs.oracle.com/javase/8/docs/technotes/guides/security/jgss/tutorials/index.html
/*Java GSS-API用于在通信应用程序之间安全地交换消息。  Java GSS-API包含RFC 2853中定义的通用安全服务应用程序接口（GSS-API）的Java绑定。
GSS-API为应用程序员提供了对各种基础安全机制（包括Kerberos）的安全服务的统一访问。

*注意：JSSE是另一个可用于安全通信的API。 有关这两者之间的差异，请参阅何时使用Java GSS-API与JSSE。
*
*
*JAAS和Java GSS-API教程一起提供的原因是因为JAAS身份验证通常在使用Java GSS-API的安全通信之前执行。 因此，
*JAAS和Java GSS-API是相关的，经常一起使用。 但是，应用程序可以在没有Java GSS-API的情况下使用JAAS，
*也可以在不使用JAAS的情况下使用Java GSS-API。 此外，JAAS本身可以用于身份验证或身份验证和授权。
*
*
*Java GSS 通用安全服务接口
*
*Java GSS-API使用所谓的“安全机制”来提供这些服务。  GSS-API实现包含对Kerberos V5机制的支持以及任何其他供应商特定的选择。
*
*Use of Java GSS-API for Secure Message Exchanges Without JAAS Programming
*/
public class JGSS_JavaGenericSecurityServices {
	
	
	public static void main(String[] args) throws Exception{
		 GSSManager manager = GSSManager.getInstance();
		 //Universal Object Identifiers (Oids)
		 Oid krb5Mechanism = new Oid("1.2.840.113554.1.2.2");
		 Oid krb5PrincipalNameType = new Oid("1.2.840.113554.1.2.2.1");

		// Identify who the client wishes to be
		GSSName userName = manager.createName("duke", GSSName.NT_USER_NAME);

		// Identify the name of the server. This uses a Kerberos specific
		// name format.
		GSSName serverName = manager.createName("nfs/foo.sun.com", krb5PrincipalNameType);

		// Acquire credentials for the user
		GSSCredential userCreds = manager.createCredential(userName, GSSCredential.DEFAULT_LIFETIME, krb5Mechanism,
				GSSCredential.INITIATE_ONLY);

		// Instantiate and initialize a security context that will be
		// established with the server
		GSSContext context = manager.createContext(serverName, krb5Mechanism, userCreds, GSSContext.DEFAULT_LIFETIME);
		 
	}

}
