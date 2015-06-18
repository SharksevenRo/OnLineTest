package com.onlinetest.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 参数操作工具类
 * 
 * @author Administrator
 * 
 */
public class ParamsUtil {

	/**
	 * 多态给
	 * 
	 * @param PreparedStatement
	 * @param t
	 *            带有值得对象
	 * @return 赋好值的PreparedStatement对象
	 * @throws Exception
	 */
	public static <T> PreparedStatement injectParams(PreparedStatement ps, T t)
			throws Exception {

		// 获取对象的字节码
		Class clazz = t.getClass();
		// 获取自定义成员变量
		Field[] fields = clazz.getDeclaredFields();

		// 遍历成员变量
		for (int i = 0; i < fields.length; i++) {
			// 获取成员变量名
			String name = fields[i].getName();
			// 将首字母转成大写
			name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
					.toUpperCase());
			// 获取当前成员变量的get方法
			Method method = clazz.getMethod("get" + name);

			// 调用当前传入对象的的get方法，获取成员变量的值
			Object value = method.invoke(t);
			// 设置值给ps的参数（即sql语句里的？）
			ps.setString(i + 1, value.toString());
		}

		// 返回已经设好值得ps对象
		return ps;
	}

	/**
	 * 动态获取ResultSet里的数据赋值给可变对象
	 * 
	 * @param rs
	 *            ResultSet
	 * @param t
	 *            要接收值得对象实例
	 * @return 已经赋好值得对象
	 * @throws Exception
	 */
	public static <T> List<T> setParams(ResultSet rs, T t) throws Exception {

		// 获取字节码
		Class clazz = t.getClass();
		// 获取自定义成员变量
		Field[] fields = clazz.getDeclaredFields();

		List<T> list = new ArrayList<T>();
		// 遍历结果集
		while (rs.next()) {
			T tempT = (T) clazz.newInstance();
			// 遍历成员变量
			for (int i = 0; i < fields.length; i++) {

				// 获取成员变量名
				String fieldName = fields[i].getName();
				// 判断成员变量是否为Timestamp类型
				if (fieldName.equals("time")) {

					Timestamp time = rs.getTimestamp("time");
					Method method = clazz.getMethod("setTime", Timestamp.class);
					method.invoke(tempT, time);
				} else {// 不是时间类型

					// 获取rs对应的值通过成员变量的名字
					String value = rs.getString(fieldName);
					// 将首字母大写
					fieldName = fieldName.replaceFirst(fieldName
							.substring(0, 1), fieldName.substring(0, 1)
							.toUpperCase());
					// 获取该成员变量对应的set方法
					Method method = clazz.getMethod("set" + fieldName,
							String.class);
					// 给要被赋值的对象的该成员变量赋值
					method.invoke(tempT, value);
				}

			}
			list.add(tempT);
		}
		// 返回已经带有值的对象
		return list;
	}
}
