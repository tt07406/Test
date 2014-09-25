/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������BaseAction
 * 
 * �������ڣ�2014-09-16
 */
package org.mystock.action;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.JSONUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ����
 * ����action�̳д���
 * ����ֱ���õ�һЩ���ö�������json��ʽ�ȵȵķ�װ����
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware,ApplicationAware{
	
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	/**
	 * �õ���ǰ��Ŀ����·��
	 * @return
	 */
	public String getBasePath() {
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	}
	
	/**
	 * �õ���Ŀ��ʵ·��
	 * @return
	 */
	public String getRealPath(){
		return request.getRealPath("/");
	}
	
	/**
	 * ��ǰ̨�������
	 * @param obj
	 */
	public void print(Object obj){
		PrintWriter out = null;
		try {
			response.setContentType("text/html;chatset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.print(obj);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
	
	/**
	 * ��������json��ʽ���
	 * @param str
	 * @return
	 */
	public void printJSON(Object obj){
		PrintWriter out = null;
		try {
			String str=JSONUtil.serialize(obj); //���������л���json��ʽ
			response.setContentType("text/html;chatset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.print(str);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out != null){
				out.close();
			}
		}
	}

	/**
	 * struts�Զ�ע����Щ����
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}
}
