package com.onlinetest.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 自定义数据库连接工具类和数据库连接池
 * @author shark
 *
 */
public class MyDBCUtils {
	
	//数据库连接池
	private static List<Connection> connPool = new ArrayList();

	//初始化数据库连接池
	static {
		for (int i = 0; i < 5; i++) {
			try {
				Class.forName("org.h2.Driver");
				//创建连接实例
				Connection conn = DriverManager
						.getConnection(
								"jdbc:h2:tcp://localhost/E:/Workspace/OnLineTest/src/com/onlinetest/db",
								"sa", "123");
				connPool.add(conn);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("数据库服务器异常");
			}
		}
	}

	/**
	 * 获取代理的连接对象（动态代理了conn的关闭连接的方法）
	 * @return
	 */
	public static Connection getConnection() {
		
		//随机从连接池里获取一个连接对象
		final Connection conn = (Connection) connPool.get(new Random()
				.nextInt(5));
		//创建代理对象
		Connection proxyConn = (Connection) Proxy.newProxyInstance(conn
				.getClass().getClassLoader(), conn.getClass().getInterfaces(),
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						//如果调用conn的close方法，什么都不干，回收到数据库连接池
						if ("close".equals(method.getName())) {
							return null;
						}
						return method.invoke(conn, args);
					}
				});
		return proxyConn;
	}

	/**
	 * 关闭数据库连接
	 * @param sm  Statement对象实例
	 * @param conn 连接对象实例
	 */
	public static void close(java.sql.Statement sm, Connection conn) {

		if (sm != null) {
			try {
				sm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				sm = null;
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
