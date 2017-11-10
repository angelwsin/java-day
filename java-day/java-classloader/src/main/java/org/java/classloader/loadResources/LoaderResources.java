package org.java.classloader.loadResources;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.CodeSigner;
import java.security.PrivilegedExceptionAction;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import sun.jvm.hotspot.interpreter.Interpreter;
import sun.jvm.hotspot.runtime.VM;
import sun.misc.ExtensionDependency;
import sun.misc.FileURLMapper;
import sun.misc.InvalidJarIndexException;
import sun.misc.JarIndex;
import sun.misc.Launcher;
import sun.misc.MetaIndex;
import sun.misc.Resource;
import sun.misc.SharedSecrets;
import sun.misc.URLClassPath;
import sun.net.util.URLUtil;
import sun.net.www.ParseUtil;

public class LoaderResources {
	
	
	public static void main(String[] args) throws Exception{
		
		
		ClassLoader  classloader = new ClassLoader() {
		};
		
		classloader.getResource("filename");
		//文件查找和加载规则类型
		//处根类加载器 其他都是复写 findResource 查找文件
		
		Launcher launcher = Launcher.getLauncher();
		
		launcher.getClassLoader();//app 加载器 System.getProperty("java.class.path")
		launcher.getClassLoader().getParent();//ext 加载器   System.getProperty("java.ext.dirs")
		launcher.getClassLoader().getParent().getParent();//null bootstrap 加载器 System.getProperty("sun.boot.class.path")
		
		URLClassLoader  urlClassLoader = new URLClassLoader(new URL[]{});
		//this class is used to maintain a search path of URLs for loading classes
		// and resources from both JAR files and directories.
		
		
		//ext
		for(URL url : getExtURLs(getExtDirs())){
			System.out.println(url.toExternalForm());
		}
		
		System.out.println();
		//classpath
		final String s = System.getProperty("java.class.path");
	    final File[] path = (s == null) ? new File[0] : getClassPath(s);
		
		URL[] urls = (s == null) ? new URL[0] : pathToURLs(path);
		for(URL url : urls){
			System.out.println(url.toExternalForm());
		}
		
		URLClassPath classPath = new URLClassPath(urls);
		URL u = classPath.findResource("config.properties", false);
		System.out.println(u.getFile());
		URL jarU = classPath.findResource("META-INF/MANIFEST.MF", false);
		
		System.out.println(jarU.getFile());
		try(InputStream is = jarU.openStream();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(is));) {
			String line = null;
			while(!Objects.isNull(line=reader.readLine())){
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ClassLoader sys = ClassLoader.getSystemClassLoader();
		Enumeration<URL> enums  = classPath.findResources("META-INF/MANIFEST.MF", false);
		while(enums.hasMoreElements()){
			URL url =  enums.nextElement();
			System.out.println(url);
		}
		
		/*String file = url.getFile();
        if (file != null && file.endsWith("/")) {
            if ("file".equals(url.getProtocol())) {
                return new FileLoader(url);
            } else {
                return new Loader(url);
            }
        } else {
            return new JarLoader(url, jarHandler, lmap);
        }*/
		
		
		Vector<Loader>  loaders = new Vector<>();
		int index = 0;
		index = index++;
		
		while(loaders.size()<index+1){
			break;
		}
		
		//hotspot
		
		//VM.initialize(arg0, false);
		VM vm = VM.getVM();
		//编译器
		Interpreter interpreter= vm.getInterpreter();
		interpreter.getCode();
		
		
		System.out.println(vm.getAddressSize());
		
		
		
		
		
	}
	//ext  ExtClassLoader
	 private static File[] getExtDirs() {
         String s = System.getProperty("java.ext.dirs");
         File[] dirs;
         if (s != null) {
             StringTokenizer st =
                 new StringTokenizer(s, File.pathSeparator);
             int count = st.countTokens();
             dirs = new File[count];
             for (int i = 0; i < count; i++) {
                 dirs[i] = new File(st.nextToken());
             }
         } else {
             dirs = new File[0];
         }
         return dirs;
     }
	 
	 private static URL[] getExtURLs(File[] dirs) throws IOException {
         Vector<URL> urls = new Vector<URL>();
         for (int i = 0; i < dirs.length; i++) {
             String[] files = dirs[i].list();
             if (files != null) {
                 for (int j = 0; j < files.length; j++) {
                     if (!files[j].equals("meta-index")) {
                         File f = new File(dirs[i], files[j]);
                         urls.add(getFileURL(f));
                     }
                 }
             }
         }
         URL[] ua = new URL[urls.size()];
         urls.copyInto(ua);
         return ua;
     }
	 
	 static URL getFileURL(File file) {
	        try {
	            file = file.getCanonicalFile();
	        } catch (IOException e) {}

	        try {
	            return ParseUtil.fileToEncodedURL(file);
	        } catch (MalformedURLException e) {
	            // Should never happen since we specify the protocol...
	            throw new InternalError(e);
	        }
	    }
	 
	 
	 //classpath
	 
	 private static File[] getClassPath(String cp) {
	        File[] path;
	        if (cp != null) {
	            int count = 0, maxCount = 1;
	            int pos = 0, lastPos = 0;
	            // Count the number of separators first
	            while ((pos = cp.indexOf(File.pathSeparator, lastPos)) != -1) {
	                maxCount++;
	                lastPos = pos + 1;
	            }
	            path = new File[maxCount];
	            lastPos = pos = 0;
	            // Now scan for each path component
	            while ((pos = cp.indexOf(File.pathSeparator, lastPos)) != -1) {
	                if (pos - lastPos > 0) {
	                    path[count++] = new File(cp.substring(lastPos, pos));
	                } else {
	                    // empty path component translates to "."
	                    path[count++] = new File(".");
	                }
	                lastPos = pos + 1;
	            }
	            // Make sure we include the last path component
	            if (lastPos < cp.length()) {
	                path[count++] = new File(cp.substring(lastPos));
	            } else {
	                path[count++] = new File(".");
	            }
	            // Trim array to correct size
	            if (count != maxCount) {
	                File[] tmp = new File[count];
	                System.arraycopy(path, 0, tmp, 0, count);
	                path = tmp;
	            }
	        } else {
	            path = new File[0];
	        }
	        // DEBUG
	        //for (int i = 0; i < path.length; i++) {
	        //  System.out.println("path[" + i + "] = " + '"' + path[i] + '"');
	        //}
	        return path;
	    }
	 
	 
	  private static URL[] pathToURLs(File[] path) {
	        URL[] urls = new URL[path.length];
	        for (int i = 0; i < path.length; i++) {
	            urls[i] = getFileURL(path[i]);
	        }
	        // DEBUG
	        //for (int i = 0; i < urls.length; i++) {
	        //  System.out.println("urls[" + i + "] = " + '"' + urls[i] + '"');
	        //}
	        return urls;
	    }


	  
	  //loader
	  private static class Loader implements Closeable {
	        private final URL base;
	        private JarFile jarfile; // if this points to a jar file

	        /*
	         * Creates a new Loader for the specified URL.
	         */
	        Loader(URL url) {
	            base = url;
	        }

	        /*
	         * Returns the base URL for this Loader.
	         */
	        URL getBaseURL() {
	            return base;
	        }

	        URL findResource(final String name, boolean check) {
	            URL url;
	            try {
	                url = new URL(base, ParseUtil.encodePath(name, false));
	            } catch (MalformedURLException e) {
	                throw new IllegalArgumentException("name");
	            }

	            try {
	                if (check) {
	                   // URLClassPath.check(url);
	                }

	                /*
	                 * For a HTTP connection we use the HEAD method to
	                 * check if the resource exists.
	                 */
	                URLConnection uc = url.openConnection();
	                if (uc instanceof HttpURLConnection) {
	                    HttpURLConnection hconn = (HttpURLConnection)uc;
	                    hconn.setRequestMethod("HEAD");
	                    if (hconn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
	                        return null;
	                    }
	                } else {
	                    // our best guess for the other cases
	                    uc.setUseCaches(false);
	                    InputStream is = uc.getInputStream();
	                    is.close();
	                }
	                return url;
	            } catch (Exception e) {
	                return null;
	            }
	        }

	        Resource getResource(final String name, boolean check) {
	            final URL url;
	            try {
	                url = new URL(base, ParseUtil.encodePath(name, false));
	            } catch (MalformedURLException e) {
	                throw new IllegalArgumentException("name");
	            }
	            final URLConnection uc;
	            try {
	                if (check) {
	                    //URLClassPath.check(url);
	                }
	                uc = url.openConnection();
	                InputStream in = uc.getInputStream();
	                if (uc instanceof JarURLConnection) {
	                    /* Need to remember the jar file so it can be closed
	                     * in a hurry.
	                     */
	                    JarURLConnection juc = (JarURLConnection)uc;
	                    jarfile = JarLoader.checkJar(juc.getJarFile());
	                }
	            } catch (Exception e) {
	                return null;
	            }
	            return new Resource() {
	                public String getName() { return name; }
	                public URL getURL() { return url; }
	                public URL getCodeSourceURL() { return base; }
	                public InputStream getInputStream() throws IOException {
	                    return uc.getInputStream();
	                }
	                public int getContentLength() throws IOException {
	                    return uc.getContentLength();
	                }
	            };
	        }

	        /*
	         * Returns the Resource for the specified name, or null if not
	         * found or the caller does not have the permission to get the
	         * resource.
	         */
	        Resource getResource(final String name) {
	            return getResource(name, true);
	        }

	        /*
	         * close this loader and release all resources
	         * method overridden in sub-classes
	         */
	        public void close () throws IOException {
	            if (jarfile != null) {
	                jarfile.close();
	            }
	        }

	        /*
	         * Returns the local class path for this loader, or null if none.
	         */
	        URL[] getClassPath() throws IOException {
	            return null;
	        }
	    }
	  
	  
	    static class JarLoader extends Loader {
	        private JarFile jar;
	        private URL csu;
	        private JarIndex index;
	        private MetaIndex metaIndex;
	        private URLStreamHandler handler;
	        private HashMap<String, Loader> lmap;
	        private boolean closed = false;
	        private static final sun.misc.JavaUtilZipFileAccess zipAccess =
	                sun.misc.SharedSecrets.getJavaUtilZipFileAccess();

	        /*
	         * Creates a new JarLoader for the specified URL referring to
	         * a JAR file.
	         */
	        JarLoader(URL url, URLStreamHandler jarHandler,
	                  HashMap<String, Loader> loaderMap)
	            throws IOException
	        {
	            super(new URL("jar", "", -1, url + "!/", jarHandler));
	            csu = url;
	            handler = jarHandler;
	            lmap = loaderMap;

	            if (!isOptimizable(url)) {
	                ensureOpen();
	            } else {
	                 String fileName = url.getFile();
	                if (fileName != null) {
	                    fileName = ParseUtil.decode(fileName);
	                    File f = new File(fileName);
	                    metaIndex = MetaIndex.forJar(f);
	                    // If the meta index is found but the file is not
	                    // installed, set metaIndex to null. A typical
	                    // senario is charsets.jar which won't be installed
	                    // when the user is running in certain locale environment.
	                    // The side effect of null metaIndex will cause
	                    // ensureOpen get called so that IOException is thrown.
	                    if (metaIndex != null && !f.exists()) {
	                        metaIndex = null;
	                    }
	                }

	                // metaIndex is null when either there is no such jar file
	                // entry recorded in meta-index file or such jar file is
	                // missing in JRE. See bug 6340399.
	                if (metaIndex == null) {
	                    ensureOpen();
	                }
	            }
	        }

	        @Override
	        public void close () throws IOException {
	            // closing is synchronized at higher level
	            if (!closed) {
	                closed = true;
	                // in case not already open.
	                ensureOpen();
	                jar.close();
	            }
	        }

	        JarFile getJarFile () {
	            return jar;
	        }

	        private boolean isOptimizable(URL url) {
	            return "file".equals(url.getProtocol());
	        }

	        private void ensureOpen() throws IOException {
	            if (jar == null) {
	                try {
	                    java.security.AccessController.doPrivileged(
	                        new java.security.PrivilegedExceptionAction<Void>() {
	                            public Void run() throws IOException {

	                                jar = getJarFile(csu);
	                                index = JarIndex.getJarIndex(jar, metaIndex);
	                                if (index != null) {
	                                    String[] jarfiles = index.getJarFiles();
	                                // Add all the dependent URLs to the lmap so that loaders
	                                // will not be created for them by URLClassPath.getLoader(int)
	                                // if the same URL occurs later on the main class path.  We set
	                                // Loader to null here to avoid creating a Loader for each
	                                // URL until we actually need to try to load something from them.
	                                    for(int i = 0; i < jarfiles.length; i++) {
	                                        try {
	                                            URL jarURL = new URL(csu, jarfiles[i]);
	                                            // If a non-null loader already exists, leave it alone.
	                                            String urlNoFragString = URLUtil.urlNoFragString(jarURL);
	                                            if (!lmap.containsKey(urlNoFragString)) {
	                                                lmap.put(urlNoFragString, null);
	                                            }
	                                        } catch (MalformedURLException e) {
	                                            continue;
	                                        }
	                                    }
	                                }
	                                return null;
	                            }
	                        }
	                    );
	                } catch (java.security.PrivilegedActionException pae) {
	                    throw (IOException)pae.getException();
	                }
	            }
	        }

	        /* Throws if the given jar file is does not start with the correct LOC */
	        static JarFile checkJar(JarFile jar) throws IOException {
	            if (System.getSecurityManager() != null && !zipAccess.startsWithLocHeader(jar)) {
	                IOException x = new IOException("Invalid Jar file");
	                try {
	                    jar.close();
	                } catch (IOException ex) {
	                    x.addSuppressed(ex);
	                }
	                throw x;
	            }

	            return jar;
	        }

	        private JarFile getJarFile(URL url) throws IOException {
	            // Optimize case where url refers to a local jar file
	            if (isOptimizable(url)) {
	                FileURLMapper p = new FileURLMapper (url);
	                if (!p.exists()) {
	                    throw new FileNotFoundException(p.getPath());
	                }
	                return checkJar(new JarFile(p.getPath()));
	            }
	            URLConnection uc = getBaseURL().openConnection();
	           // uc.setRequestProperty(USER_AGENT_JAVA_VERSION, JAVA_VERSION);
	            JarFile jarFile = ((JarURLConnection)uc).getJarFile();
	            return checkJar(jarFile);
	        }

	        /*
	         * Returns the index of this JarLoader if it exists.
	         */
	        JarIndex getIndex() {
	            try {
	                ensureOpen();
	            } catch (IOException e) {
	                throw new InternalError(e);
	            }
	            return index;
	        }

	        /*
	         * Creates the resource and if the check flag is set to true, checks if
	         * is its okay to return the resource.
	         */
	        Resource checkResource(final String name, boolean check,
	            final JarEntry entry) {

	            final URL url;
	            try {
	                url = new URL(getBaseURL(), ParseUtil.encodePath(name, false));
	                
	            } catch (MalformedURLException e) {
	                return null;
	                // throw new IllegalArgumentException("name");
	            } catch (IOException e) {
	                return null;
	            } catch (AccessControlException e) {
	                return null;
	            }

	            return new Resource() {
	                public String getName() { return name; }
	                public URL getURL() { return url; }
	                public URL getCodeSourceURL() { return csu; }
	                public InputStream getInputStream() throws IOException
	                    { return jar.getInputStream(entry); }
	                public int getContentLength()
	                    { return (int)entry.getSize(); }
	                public Manifest getManifest() throws IOException
	                    { return jar.getManifest(); };
	                public Certificate[] getCertificates()
	                    { return entry.getCertificates(); };
	                public CodeSigner[] getCodeSigners()
	                    { return entry.getCodeSigners(); };
	            };
	        }


	        /*
	         * Returns true iff atleast one resource in the jar file has the same
	         * package name as that of the specified resource name.
	         */
	        boolean validIndex(final String name) {
	            String packageName = name;
	            int pos;
	            if((pos = name.lastIndexOf("/")) != -1) {
	                packageName = name.substring(0, pos);
	            }

	            String entryName;
	            ZipEntry entry;
	            Enumeration<JarEntry> enum_ = jar.entries();
	            while (enum_.hasMoreElements()) {
	                entry = enum_.nextElement();
	                entryName = entry.getName();
	                if((pos = entryName.lastIndexOf("/")) != -1)
	                    entryName = entryName.substring(0, pos);
	                if (entryName.equals(packageName)) {
	                    return true;
	                }
	            }
	            return false;
	        }

	        /*
	         * Returns the URL for a resource with the specified name
	         */
	        URL findResource(final String name, boolean check) {
	            Resource rsc = getResource(name, check);
	            if (rsc != null) {
	                return rsc.getURL();
	            }
	            return null;
	        }

	        /*
	         * Returns the JAR Resource for the specified name.
	         */
	        Resource getResource(final String name, boolean check) {
	            if (metaIndex != null) {
	                if (!metaIndex.mayContain(name)) {
	                    return null;
	                }
	            }

	            try {
	                ensureOpen();
	            } catch (IOException e) {
	                throw new InternalError(e);
	            }
	            final JarEntry entry = jar.getJarEntry(name);
	            if (entry != null)
	                return checkResource(name, check, entry);

	            if (index == null)
	                return null;

	            HashSet<String> visited = new HashSet<String>();
	            return getResource(name, check, visited);
	        }

	        /*
	         * Version of getResource() that tracks the jar files that have been
	         * visited by linking through the index files. This helper method uses
	         * a HashSet to store the URLs of jar files that have been searched and
	         * uses it to avoid going into an infinite loop, looking for a
	         * non-existent resource
	         */
	        Resource getResource(final String name, boolean check,
	                             Set<String> visited) {

	            Resource res;
	            String[] jarFiles;
	            int count = 0;
	            LinkedList<String> jarFilesList = null;

	            /* If there no jar files in the index that can potential contain
	             * this resource then return immediately.
	             */
	            if((jarFilesList = index.get(name)) == null)
	                return null;

	            do {
	                int size = jarFilesList.size();
	                jarFiles = jarFilesList.toArray(new String[size]);
	                /* loop through the mapped jar file list */
	                while(count < size) {
	                    String jarName = jarFiles[count++];
	                    JarLoader newLoader;
	                    final URL url;

	                    try{
	                        url = new URL(csu, jarName);
	                        String urlNoFragString = URLUtil.urlNoFragString(url);
	                        if ((newLoader = (JarLoader)lmap.get(urlNoFragString)) == null) {
	                            /* no loader has been set up for this jar file
	                             * before
	                             */
	                            newLoader = AccessController.doPrivileged(
	                                new PrivilegedExceptionAction<JarLoader>() {
	                                    public JarLoader run() throws IOException {
	                                        return new JarLoader(url, handler,
	                                            lmap);
	                                    }
	                                });

	                            /* this newly opened jar file has its own index,
	                             * merge it into the parent's index, taking into
	                             * account the relative path.
	                             */
	                            JarIndex newIndex = newLoader.getIndex();
	                            if(newIndex != null) {
	                                int pos = jarName.lastIndexOf("/");
	                                newIndex.merge(this.index, (pos == -1 ?
	                                    null : jarName.substring(0, pos + 1)));
	                            }

	                            /* put it in the global hashtable */
	                            lmap.put(urlNoFragString, newLoader);
	                        }
	                    } catch (java.security.PrivilegedActionException pae) {
	                        continue;
	                    } catch (MalformedURLException e) {
	                        continue;
	                    }


	                    /* Note that the addition of the url to the list of visited
	                     * jars incorporates a check for presence in the hashmap
	                     */
	                    boolean visitedURL = !visited.add(URLUtil.urlNoFragString(url));
	                    if (!visitedURL) {
	                        try {
	                            newLoader.ensureOpen();
	                        } catch (IOException e) {
	                            throw new InternalError(e);
	                        }
	                        final JarEntry entry = newLoader.jar.getJarEntry(name);
	                        if (entry != null) {
	                            return newLoader.checkResource(name, check, entry);
	                        }

	                        /* Verify that at least one other resource with the
	                         * same package name as the lookedup resource is
	                         * present in the new jar
	                         */
	                        if (!newLoader.validIndex(name)) {
	                            /* the mapping is wrong */
	                            throw new InvalidJarIndexException("Invalid index");
	                        }
	                    }

	                    /* If newLoader is the current loader or if it is a
	                     * loader that has already been searched or if the new
	                     * loader does not have an index then skip it
	                     * and move on to the next loader.
	                     */
	                    if (visitedURL || newLoader == this ||
	                            newLoader.getIndex() == null) {
	                        continue;
	                    }

	                    /* Process the index of the new loader
	                     */
	                    if((res = newLoader.getResource(name, check, visited))
	                            != null) {
	                        return res;
	                    }
	                }
	                // Get the list of jar files again as the list could have grown
	                // due to merging of index files.
	                jarFilesList = index.get(name);

	            // If the count is unchanged, we are done.
	            } while(count < jarFilesList.size());
	            return null;
	        }


	        /*
	         * Returns the JAR file local class path, or null if none.
	         */
	        URL[] getClassPath() throws IOException {
	            if (index != null) {
	                return null;
	            }

	            if (metaIndex != null) {
	                return null;
	            }

	            ensureOpen();
	            parseExtensionsDependencies();

	            if (SharedSecrets.javaUtilJarAccess().jarFileHasClassPathAttribute(jar)) { // Only get manifest when necessary
	                Manifest man = jar.getManifest();
	                if (man != null) {
	                    Attributes attr = man.getMainAttributes();
	                    if (attr != null) {
	                        String value = attr.getValue(Name.CLASS_PATH);
	                        if (value != null) {
	                            return parseClassPath(csu, value);
	                        }
	                    }
	                }
	            }
	            return null;
	        }

	        /*
	         * parse the standard extension dependencies
	         */
	        private void  parseExtensionsDependencies() throws IOException {
	            ExtensionDependency.checkExtensionsDependencies(jar);
	        }

	        /*
	         * Parses value of the Class-Path manifest attribute and returns
	         * an array of URLs relative to the specified base URL.
	         */
	        private URL[] parseClassPath(URL base, String value)
	            throws MalformedURLException
	        {
	            StringTokenizer st = new StringTokenizer(value);
	            URL[] urls = new URL[st.countTokens()];
	            int i = 0;
	            while (st.hasMoreTokens()) {
	                String path = st.nextToken();
	                urls[i] = new URL(base, path);
	                i++;
	            }
	            return urls;
	        }
	    }
	    
	    
	    private static class FileLoader extends Loader {
	        /* Canonicalized File */
	        private File dir;

	        FileLoader(URL url) throws IOException {
	            super(url);
	            if (!"file".equals(url.getProtocol())) {
	                throw new IllegalArgumentException("url");
	            }
	            String path = url.getFile().replace('/', File.separatorChar);
	            path = ParseUtil.decode(path);
	            dir = (new File(path)).getCanonicalFile();
	        }

	        /*
	         * Returns the URL for a resource with the specified name
	         */
	        URL findResource(final String name, boolean check) {
	            Resource rsc = getResource(name, check);
	            if (rsc != null) {
	                return rsc.getURL();
	            }
	            return null;
	        }

	        Resource getResource(final String name, boolean check) {
	            final URL url;
	            try {
	                URL normalizedBase = new URL(getBaseURL(), ".");
	                url = new URL(getBaseURL(), ParseUtil.encodePath(name, false));

	                if (url.getFile().startsWith(normalizedBase.getFile()) == false) {
	                    // requested resource had ../..'s in path
	                    return null;
	                }


	                final File file;
	                if (name.indexOf("..") != -1) {
	                    file = (new File(dir, name.replace('/', File.separatorChar)))
	                          .getCanonicalFile();
	                    if ( !((file.getPath()).startsWith(dir.getPath())) ) {
	                        /* outside of base dir */
	                        return null;
	                    }
	                } else {
	                    file = new File(dir, name.replace('/', File.separatorChar));
	                }

	                if (file.exists()) {
	                    return new Resource() {
	                        public String getName() { return name; };
	                        public URL getURL() { return url; };
	                        public URL getCodeSourceURL() { return getBaseURL(); };
	                        public InputStream getInputStream() throws IOException
	                            { return new FileInputStream(file); };
	                        public int getContentLength() throws IOException
	                            { return (int)file.length(); };
	                    };
	                }
	            } catch (Exception e) {
	                return null;
	            }
	            return null;
	        }
	    }
	    
	    //loaders 
	    private Loader getLoader(final URL url) throws IOException {
	        try {
	            return java.security.AccessController.doPrivileged(
	                new java.security.PrivilegedExceptionAction<Loader>() {
	                public Loader run() throws IOException {
	                    String file = url.getFile();
	                    if (file != null && file.endsWith("/")) {
	                        if ("file".equals(url.getProtocol())) {
	                            return new FileLoader(url);
	                        } else {
	                            return new Loader(url);
	                        }
	                    } else {
	                       return null;// return new JarLoader(url, jarHandler, lmap);
	                    }
	                }
	            });
	        } catch (java.security.PrivilegedActionException pae) {
	            throw (IOException)pae.getException();
	        }
	    }

}
