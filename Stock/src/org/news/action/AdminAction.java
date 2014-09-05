/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AdminAction
 * 
 * �������ڣ�2014-08-20
 */
package org.news.action;

import java.util.List;

import org.news.model.Admin;
import org.news.service.AdminService;
import org.news.utils.MD5Code;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ڹ���Ա��������Action
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

	List<Admin> all;//����Ա�б�
	String adminName;//����Ա����
	String note;//����Ա��Ϣ
	String password;//����Ա����
	String msg;//��ʾ��Ϣ
	String url;//URL
	String adminid;//����ԱID
	Admin admin;//����Ա��Ϣ

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
	 * ��ȡ���еĹ���Ա�б�
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
	 * ���ӹ���Ա
	 * @return
	 */
	public String insert(){
		Admin admin = new Admin(0,"","","");
		List<Admin> adminList = adminService.getAllAdmin();
	    int adminID = ((adminList.size() == 0)? 1 : (adminList.get(adminList.size()-1).getAdminId()+1));
	    admin.setAdminId(adminID);
		admin.setAdminName(adminName);
		admin.setAdminInfo(note);
		admin.setAdminPass(new MD5Code().getMD5ofStr(password));//����Ҫ����
		
		try {//�������ݱ���
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
	 * ����ǰ�Ĳ���
	 * @return
	 */
	public String updatepre(){

		try {//����ID��Ӧ�Ĺ���Ա��Ϣ
			Admin admin = adminService.findAdminById(Integer.parseInt(adminid));
			setAdmin(admin);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * ���¹���Ա
	 * @return
	 */
	public String update(){
		//�����޸ĵ�ֵ�½�VO
		Admin admin = new Admin(0,"","","");

		admin.setAdminId(Integer.parseInt(adminid));
		admin.setAdminName(adminName);
		admin.setAdminInfo(note);
		admin.setAdminPass(new MD5Code().getMD5ofStr(password));
		try {//�������ݿ�
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
	 * �鿴����Ա��Ϣ
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
	 * ɾ������Ա��Ϣ
	 * @return
	 */
	public String delete(){
		int[] ids = new int[1];//��ʱֻ��ɾ��һ��
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