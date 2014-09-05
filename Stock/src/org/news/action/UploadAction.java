package org.news.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * @author 张轮
 * 后台处理上传图片
 *
 */
public class UploadAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2619997997729594861L;
	private File imgFile;
	
	public void upload(){
		try {
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
			Random r=new Random();
			String path=ServletActionContext.getServletContext().getRealPath("/");
			String imgName=sdf.format(new Date())+r.nextInt(100)+".jpg";
		
			FileUtils.copyFile(imgFile,new File(path+"upload/"+imgName));
			
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