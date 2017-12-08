package org.java.security.def;

import java.security.Provider;

public class ProviderDef  extends Provider{

	/**
	 * 1.注册provider
	 * 2.注册 spi
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ProviderDef() {
		super("ProviderDef", 1.9d, "info");
		
		/*
		 * 扩展实现
         * spi service provider interface
         */
        put("Cipher.RSAExt", "org.java.security.def.RSAExtCipher");
	}

}
