package com.onlinetest.filter;

import java.io.IOException;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter {
	@SuppressWarnings("unused")
	
	private FilterConfig config = null;
	private ServletContext context = null;
	private String encode = null;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//--响应乱码解决
		response.setCharacterEncoding(encode);
		response.setContentType("text/html;charset="+encode);
		//--利用装饰设计模式改变request对象和获取请求参数相关的方法,从而解决请求参数乱码问 题
		chain.doFilter(new MyHttpServletRequest((HttpServletRequest) request), response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		this.context = filterConfig.getServletContext();
		this.encode = context.getInitParameter("encode");
	}

	/**
	 * HttpServletRequest的包装类解决乱码
	 * @author Administrator
	 *
	 */
	private class MyHttpServletRequest extends HttpServletRequestWrapper{
		
		private  HttpServletRequest request = null;
		//标记是否已经硬解码
		private boolean isNotEncode = true;
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		
		@Override
		public Map<String,String[]> getParameterMap() {
			try{
				if(request.getMethod().equalsIgnoreCase("POST")){
					//post方式提交
					request.setCharacterEncoding(encode);//设置解码格式
					return request.getParameterMap();
				}else if(request.getMethod().equalsIgnoreCase("GET")){
					
					//get方式提交
					Map<String,String[]> map = request.getParameterMap();//获取保存请求参数的map
					if(isNotEncode){
						//还未硬解码
						//遍历map
						for(Map.Entry<String, String[]> entry : map.entrySet()){
							String [] vs = entry.getValue();
							for(int i=0;i<vs.length;i++){
								
								//对每个请求参数硬解码
								vs[i] = new String(vs[i].getBytes("iso8859-1"),encode);
							}
						}
						isNotEncode = false;
					}
					return map;
				}else{
					return request.getParameterMap();
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		@Override
		public String[] getParameterValues(String name) {
			return getParameterMap().get(name);
		}
		
		@Override
		public String getParameter(String name) {
			return getParameterValues(name) == null ? null : getParameterValues(name)[0];
		}
		
	} 
}
