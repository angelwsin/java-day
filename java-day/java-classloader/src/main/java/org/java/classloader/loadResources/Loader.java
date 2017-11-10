package org.java.classloader.loadResources;

public class Loader {
	
	public static void main(String[] args) {
		/**
		 *  0: ldc           #1                  // class org/java/classloader/loadResources/Loader
            2: invokevirtual #16                 // Method java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
		 */
		Loader.class.getClassLoader();
	}

}
