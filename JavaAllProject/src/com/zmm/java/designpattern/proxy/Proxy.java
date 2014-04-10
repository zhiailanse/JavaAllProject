package com.zmm.java.designpattern.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	
	public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception{
		String rt = "\r\n";
		String methodStr = "";
		Method[] methods = infce.getMethods();
		
		
		for(Method m : methods){
		methodStr += 
				"@Override" + rt +
				"  public void " + m.getName() + "(){" + rt +
				"  try {" + rt +
				"   Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" +  rt +
				"   h.invoke(this, md);" + rt +
				"  }catch(Exception e){e.printStackTrace();}" + rt +
				
				"}";
				
	}
		
//		for(Method m : methods){
//			methodStr += 
//					"@Override" + rt +
//					"  public void " + m.getName() + "(){" + rt +
//					"    System.out.println(\"begin loging ...\");" + rt +
//					"    moveable." + m.getName() + "();" + rt +
//					"    System.out.println(\"Loging finish.\");" + rt +
//					"}";
//					
//		}
		
//		System.out.println(methodStr);
		
		String src = 
		"package com.zmm.java.dp.proxy;" + rt +
		"import java.lang.reflect.Method;" + rt +
		"  public class PlussLogMoveable implements " + infce.getName()+ "{" + rt +
			"  com.zmm.java.dp.proxy.InvocationHandler h;" + rt +
			"  public PlussLogMoveable(com.zmm.java.dp.proxy.InvocationHandler h) {" + rt +
				"  this.h = h;" + rt +
			"  }" + rt +
			methodStr + rt +
		"}" ;
		
		String fileName = 
				"D:/src/com/zmm/java/dp/proxy/PlussLogMoveable.java";
//		System.out.println(fileName);
		File f = new File(fileName);
		
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//		System.out.println(compiler.getClass().getName());
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load into memory and create an instance
		URL[] urls = new URL[]{new URL("file:/" + "D:/src/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.zmm.java.dp.proxy.PlussLogMoveable");

		Constructor constructor = c.getConstructor(InvocationHandler.class);
		Object m = (Moveable) constructor.newInstance(h);
//		m.move();
		
		return m;
	}
	
}
