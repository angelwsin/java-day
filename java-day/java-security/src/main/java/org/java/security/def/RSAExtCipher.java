package org.java.security.def;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class RSAExtCipher extends CipherSpi {

	@Override
	protected byte[] engineDoFinal(byte[] arg0, int arg1, int arg2)
			throws IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int engineDoFinal(byte[] arg0, int arg1, int arg2, byte[] arg3, int arg4)
			throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int engineGetBlockSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected byte[] engineGetIV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int engineGetOutputSize(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected AlgorithmParameters engineGetParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void engineInit(int arg0, Key arg1, SecureRandom arg2) throws InvalidKeyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void engineInit(int arg0, Key arg1, AlgorithmParameterSpec arg2, SecureRandom arg3)
			throws InvalidKeyException, InvalidAlgorithmParameterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void engineInit(int arg0, Key arg1, AlgorithmParameters arg2, SecureRandom arg3)
			throws InvalidKeyException, InvalidAlgorithmParameterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void engineSetMode(String arg0) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void engineSetPadding(String arg0) throws NoSuchPaddingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected byte[] engineUpdate(byte[] arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int engineUpdate(byte[] arg0, int arg1, int arg2, byte[] arg3, int arg4) throws ShortBufferException {
		// TODO Auto-generated method stub
		return 0;
	}

}
