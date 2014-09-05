/*
 * 系统名称：新闻发布系统
 * 
 * 类名：UsersAction
 * 
 * 创建日期：2014-08-21
 */
package org.news.action;

import java.util.List;

import org.news.model.Users;
import org.news.service.UserService;
import org.news.utils.MD5Code;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于会员操作的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class UsersAction extends ActionSupport {

	private static final long serialVersionUID = -7456160560536320060L;
	private UserService userService;
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	String kw;//查询关键字
	String pg;  //URL
	String cp; //为当前所在的页
	String ls; //每次显示的记录数
	long recorders; //查询到的全部记录数
	String url;
	int page;
	int size;
	int pid; //会员ID
	Users user; //会员信息
	List<Users> users; //会员列表
	String msg;//提示信息

	String mid;//账号
	String password;//密码
	String info;//备注
	String realName;//真实姓名
	String sex;//性别
	String email;//电子邮件
	String phone;//电话号码
	String idNum;//身份证号

	
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
	
	public String getKw() {
		return kw;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLs() {
		return ls;
	}

	public void setLs(String ls) {
		this.ls = ls;
	}

	/**
	 * @return the allRecorders
	 */
	public long getRecorders() {
		return recorders;
	}

	/**
	 * @param allRecorders the allRecorders to set
	 */
	public void setRecorders(long recorders) {
		this.recorders = recorders;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = new MD5Code().getMD5ofStr(password);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	/**
	 * @return
	 */
	public String execute() {
		return SUCCESS;
	}
	
	/**
	 * 获取所有的会员列表
	 * @return
	 */
	public String list(){
		String URL = "Users_list.action" ;
		
		try {
			int currentPage = 1 ;	// 为当前所在的页，默认在第1页
			int lineSize = 20;		// 每次显示的记录数
			long allRecorders = 0 ;	// 表示全部的记录数
			String keyWord = kw;	// 接收查询关键字
			
			try{
				currentPage = Integer.parseInt(cp) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(ls) ;
			} catch(Exception e) {}
			if(keyWord == null){
				keyWord = "" ;	// 如果模糊查询没有关键字，则表示查询全部
			}
			
			List<Users> all = userService.getAllUsers(keyWord,currentPage,lineSize) ;
			allRecorders = userService.getCount(keyWord) ;
			setUsers(all);
			setRecorders(allRecorders);
			setUrl(URL);
			setPage(currentPage);
			setSize(lineSize);
	
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 查看会 员信息
	 * @return
	 */
	public String show(){
		int userId = pid ;
		try {//获取当前会员VO，传给下个页面
			Users pro = userService.findUsersById(userId);
			if(pro != null) {
				setUser(pro);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 删除会员信息
	 * @return
	 */
	public String delete(){
		int currentPage = 1 ;	// 为当前所在的页，默认在第1页
		int lineSize = 20;		// 每次显示的记录数
		String page = pg ;
		try{
			currentPage = Integer.parseInt(cp) ;
		} catch(Exception e) {}
		try{
			lineSize = Integer.parseInt(ls) ;
		} catch(Exception e) {}

		int[] usersId = new int[1];
		usersId[0] = pid;
		try {
			if (userService.deleteUserss(usersId)) {
				setMsg(MessageUtil
						.get("user.delete.true"));
			} else {
				setMsg(MessageUtil
						.get("user.delete.false"));
			}
			
			//将参数转化成属性传给下个页面
			setPg(page);
			setCp(""+currentPage);
			setLs(""+lineSize);
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
		int userId = pid ;
		try {//获取当前会员VO，传给下个页面
			Users pro = userService.findUsersById(userId);
			if(pro != null) {
				setUser(pro);
			}
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
		int userid = pid;
		
		int currentPage = 1 ;	// 为当前所在的页，默认在第1页
		int lineSize = 20;		// 每次显示的记录数
		String page = pg ;
		try{
			currentPage = Integer.parseInt(cp) ;
		} catch(Exception e) {}
		try{
			lineSize = Integer.parseInt(ls) ;
		} catch(Exception e) {}
		
		Users user = new Users(userid,mid,password,info,realName,sex,email,phone,idNum);
		try {//更新数据库
			if (userService.updateUsers(user)) {
				setMsg(MessageUtil
						.get("user.update.true"));
			} else {
				setMsg(MessageUtil
						.get("user.update.false"));
			}
			
			setPg(page);
			setCp(""+currentPage);
			setLs(""+lineSize);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}