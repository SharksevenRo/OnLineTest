package com.onlinetest.factory;

import java.io.FileReader;
import java.util.Properties;

/**
 * 实例化对象的工厂类
 * @author Administrator
 *
 */
public class MyFactory {

	private static  Properties pro=null;
	private static MyFactory factory=null;
	
	/**
	 * 读取配置文件，获取配置对象实例pro
	 */
	static{	
		pro=new Properties();
		try {
			pro.load(new FileReader(MyFactory.class.getClassLoader().getResource("factoryConf.properties").getPath()));
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	private MyFactory(){}
	
	/**
	 * 获取工厂实例（单例）
	 * @return
	 */
	public static MyFactory getFactory(){
		factory=new MyFactory();
		return factory; 	
	}
	/**
	 * 根据接口的字节码实例化接口的实现对象
	 * @param clazz 接口的class对象实例
	 * @return 实现该接口的实现类实例
	 */
	public <T> T getInstance(Class clazz){
		
		//获取字节码对象的全类名
		String realName=clazz.getSimpleName();
		//根据字节码对象的全类名获取实现类的全类名
		String impName=pro.getProperty(realName);
		try {
			//根据全类名反射实例化一个实现类对象实例
			return (T) Class.forName(impName).newInstance();
		} catch (Exception e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
