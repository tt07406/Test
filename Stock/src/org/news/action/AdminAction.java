/*
 * 系统名称：新闻发布系统
 * 
 * 类名：AdminAction
 * 
 * 创建日期：2014-08-20
 */
package org.news.action;

import java.util.List;

import org.news.model.Admin;
import org.news.service.AdminService;
import org.news.utils.MD5Code;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于管理员类别操作的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = -7878912791202566739L;
	private AdminService adminService;
	
	/**
	 * @param adminService the adminService to set
	 */
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	List<Admin> all;//管理员列表
	String adminName;//管理员名称
	String note;//管理员信息
	String password;//管理员密码
	String msg;//提示信息
	String url;//URL
	String adminid;//管理员ID
	Admin admin;//管理员信息

	/**
	 * @return the adminid
	 */
	public String getAdminid() {
		return adminid;
	}

	/**
	 * @param adminid the adminid to set
	 */
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	/**
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the all
	 */
	public List<Admin> getAll() {
		return all;
	}

	/**
	 * @param all the all to set
	 */
	public void setAll(List<Admin> all) {
		this.all = all;
	}

	/**
	 * @return
	 */
	public String execute() {

		return SUCCESS;
	}
	
	/**
	 * 获取所有的管理员列表
	 * @return
	 */
	public String list(){
		try {
			setAll(adminService.getAllAdmin());

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 增加管理员
	 * @return
	 */
	public String insert(){
		Admin admin = new Admin(0,"","","");
		List<Admin> adminList = adminService.getAllAdmin();
	    int adminID = ((adminList.size() == 0)? 1 : (adminList.get(adminList.size()-1).getAdminId()+1));
	    admin.setAdminId(adminID);
		admin.setAdminName(adminName);
		admin.setAdminInfo(note);
		admin.setAdminPass(new MD5Code().getMD5ofStr(password));//密码要加密
		
		try {//插入数据表中
			if (adminService.addAdmin(admin)) {
				setMsg(MessageUtil
						.get("admin.insert.true"));
			} else {
				setMsg(MessageUtil
						.get("admin.insert.false"));
			}
			setUrl("admin_insert.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 更新前的操作
	 * @return
	 */
	public String updatepre(){

		try {//找了ID对应的管理员信息
			Admin admin = adminService.findAdminById(Integer.parseInt(adminid));
			setAdmin(admin);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 更新管理员
	 * @return
	 */
	public String update(){
		//根据修改的值新建VO
		Admin admin = new Admin(0,"","","");

		admin.setAdminId(Integer.parseInt(adminid));
		admin.setAdminName(adminName);
		admin.setAdminInfo(note);
		admin.setAdminPass(new MD5Code().getMD5ofStr(password));
		try {//更新数据库
			if (adminService.updateAdmin(admin)) {
					setMsg(MessageUtil
						.get("admin.update.true"));
			} else {
					setMsg(MessageUtil
						.get("admin.update.false"));
			}
			setUrl("Admin_list");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * 查看管理员信息
	 * @return
	 */
	public String show(){
		try {
			Admin admin = adminService.findAdminById(Integer.parseInt(adminid));
			setAdmin(admin);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 删除管理员信息
	 * @return
	 */
	public String delete(){
		int[] ids = new int[1];//暂时只能删除一个
		ids[0] = Integer.parseInt(adminid);
		try {
			if (adminService.deleteAdmins(ids)) {
				setMsg(MessageUtil
						.get("admin.delete.true"));
			} else {
				setMsg(MessageUtil
						.get("admin.delete.true"));
			}
			setUrl("Admin_list");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}