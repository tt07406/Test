/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������Admin
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.model;

/**
 * ����ԱVO
 * 
 * @author tt
 * @version 14.9.16
 */
public class Admin {

	private String adminName;	//����Ա�û�
	private String adminPass;	//����Ա����
	private int adminLevel;		//����ԱȨ�޵ȼ�
	
	
	/**
	 * ��ʼ������
	 * @param adminName
	 * @param adminPass
	 * @param adminLevel
	 */
	public Admin(String adminName, String adminPass, int adminLevel) {
		super();
		this.adminName = adminName;
		this.adminPass = adminPass;
		this.adminLevel = adminLevel;
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
	 * @return the adminPass
	 */
	public String getAdminPass() {
		return adminPass;
	}
	/**
	 * @param adminPass the adminPass to set
	 */
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	/**
	 * @return the adminLevel
	 */
	public int getAdminLevel() {
		return adminLevel;
	}
	/**
	 * @param adminLevel the adminLevel to set
	 */
	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}
}
