/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������ValidateNameAction
 * 
 * �������ڣ�2014-08-27
 */
package org.news.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.news.service.AdminService;
import org.news.service.NewsTypeService;
import org.news.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import org.news.utils.Constant.Type;

/**
 * ��֤�ظ��������Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class ValidateNameAction extends ActionSupport {

	private static final long serialVersionUID = 7238313406542433777L;
	private UserService userService;
	private AdminService adminService;
	private NewsTypeService newstypeService;
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param adminService the adminService to set
	 */
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * @param newstypeService the newstypeService to set
	 */
	public void setNewstypeService(NewsTypeService newstypeService) {
		this.newstypeService = newstypeService;
	}
	private String userName;//ע����û��˺�
	private String tip;//���ص���ʾ
	private int type = 0;//0Ϊ��Ա��1Ϊ����Ա��3Ϊ�������4Ϊ���ű���

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public InputStream getTip() throws IOException{
		return new ByteArrayInputStream(tip.getBytes("utf-8"));
	}
	public String execute() {
		Type style = Type.values()[this.type];
		
		switch (style){
			case MEMBER:
				if (userService.findUserName(userName)){
					tip = "<span style='color:red'>" + userName + "�Ѵ��ڣ�����������</span>";
				}else{
					tip = "";
				}
				break;
			case ADMIN:
				if (adminService.findAdminName(userName)){
					tip = "<span style='color:red'>" + userName + "�Ѵ��ڣ�����������</span>";
				}else{
					tip = "";
				}
				break;
			case NEWSTYPE:
				if (newstypeService.findNewsTypeName(userName)){
					tip = "<span style='color:red'>" + userName + "�Ѵ��ڣ�����������</span>";
				}else{
					tip = "";
				}
				break;
			default:
				break;
		}
	
		
		return SUCCESS;
	}
}