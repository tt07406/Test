/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：UploadAction
 * 
 * 创建日期：2014-09-16
 */
package org.mystock.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.mystock.utils.FtpUtil;
import org.mystock.utils.MessageUtil;


/**
 * 后台处理上传图片
 * @author tt
 * @version 14.9.16
 */
public class UploadAction extends BaseAction {

	private static final long serialVersionUID = -1154768183800684676L;

	private File imgFile;
	
	public void upload(){
		try {			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
			Random r=new Random();
			String path=ServletActionContext.getServletContext().getRealPath("/");
			String imgName=sdf.format(new Date())+r.nextInt(100)+".jpg";
		
			FileUtils.copyFile(imgFile,new File(path+"upload/"+imgName));
			
			if (FtpUtil.isValid()){
				//备份文件到FTP
				if(FtpUtil.backupFile(path+"upload/"+imgName, imgName,"upload/"+MessageUtil.getID("config.id"))){
					System.out.println("upload:"+imgName+" backup success");
				}else{
					System.out.println("upload:"+imgName+" backup fail");
				}
			}
			
			//向kindeditor返回json格式图片路径
			String outPath=ServletActionContext.getRequest().getScheme()+"://"+ServletActionContext.getRequest().getServerName()+":"+ServletActionContext.getRequest().getServerPort()+ServletActionContext.getRequest().getContextPath()+"/";
			
			String outImageName=outPath+"upload/"+imgName;
			String returnUrl="{\"error\":0,\"url\":\""+outImageName+"\"}";
			ServletActionContext.getResponse().getWriter().print(returnUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public File getImgFile() {
		return imgFile;
	}
	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}
	
}