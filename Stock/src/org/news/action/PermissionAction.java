/*
 * 系统名称：新闻发布系统
 * 
 * 类名：PermissionAction
 * 
 * 创建日期：2014-09-23
 */
package org.news.action;

import java.util.List;

import org.news.model.Permission;
import org.news.service.PermissionService;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于权限操作的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class PermissionAction extends ActionSupport {

	private static final long serialVersionUID = -4995630341210552569L;
	
	private PermissionService permissionService;

	/**
	 * @param permissionService the permissionService to set
	 */
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	List<Permission> all;//所有权限
	String idNumber;//身份证ID
	String authenticationId;//授权ID
	String msg;//提示消息
	int level;//授权等级
	String cmt;//备注
	String url;//URL
	int permissionid;//权限ID
	Permission permission;//具体权限

	/**
	 * @return the cmt
	 */
	public String getCmt() {
		return cmt;
	}
	/**
	 * @param cmt the cmt to set
	 */
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	/**
	 * @return the all
	 */
	public List<Permission> getAll() {
		return all;
	}
	/**
	 * @param all the all to set
	 */
	public void setAll(List<Permission> all) {
		this.all = all;
	}
	/**
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * @return the authenticationId
	 */
	public String getAuthenticationId() {
		return authenticationId;
	}
	/**
	 * @param authenticationId the authenticationId to set
	 */
	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
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
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
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
	 * @return the permissionid
	 */
	public int getPermissionid() {
		return permissionid;
	}
	/**
	 * @param permissionid the permissionid to set
	 */
	public void setPermissionid(int permissionid) {
		this.permissionid = permissionid;
	}
	/**
	 * @return the permission
	 */
	public Permission getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	/**
	 * 获取所有的权限列表
	 * @return
	 */
	public String list(){
		try {
			setAll(permissionService.getAllPermissions());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 插入权限
	 * @return
	 */
	public String insert(){
		try {
			if (permissionService.addPermission(new Permission(0,idNumber,authenticationId,level,cmt))) {
				setMsg(MessageUtil
						.get("permission.insert.true"));
			} else {
				setMsg(MessageUtil
						.get("permission.insert.false"));
			}
			setUrl("permission_insert.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 更新权限
	 * @return
	 */
	public String update(){

		try {//更新数据库
			if (permissionService.updatePermissions(new Permission(permissionid,idNumber,authenticationId,level,cmt))) {
				setMsg(MessageUtil
						.get("permission.update.true"));
			} else {
				setMsg(MessageUtil
						.get("permission.update.false"));
			}
			setUrl("Permission_list.action");
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
		try {//找了ID对应的频道信息
			permission = permissionService.findPermissionById(permissionid);
			level = permission.getPermissionLevel();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 删除权限
	 * @return
	 */
	public String delete(){
		try {
			int [] permissionIds = new int[1];
			permissionIds[0] = permissionid;
			if(permissionService.deletePermissions(permissionIds)){
				setMsg(MessageUtil
						.get("permission.delete.true"));
			} else {
				setMsg(MessageUtil
						.get("permission.delete.false"));
			}
			setUrl("Permission_list.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 查看频道信息
	 * @return
	 */
	public String show(){
		try {
			permission = permissionService.findPermissionById(permissionid);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}
