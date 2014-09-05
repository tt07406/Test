/*
 * 系统名称：新闻发布系统
 * 
 * 类名：DownloadAttachmentAction
 * 
 * 创建日期：2014-08-26
 */
package org.news.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.news.model.NewsAttachment;
import org.news.service.AttachmentService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于下载操作的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class DownloadAttachmentAction extends ActionSupport {

	private static final long serialVersionUID = -2785222973669170301L;
	private AttachmentService service;
	
	/**
	 * @param service the service to set
	 */
	public void setService(AttachmentService service) {
		this.service = service;
	}


	Long id;//附件ID

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	public void download(){
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			NewsAttachment attachment = service.findNewsAttachmentById(id);
			String filename = attachment.getAttachmentName();
			response.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("gb2312"), "ISO8859-1" ));
			ServletOutputStream out = response.getOutputStream();
			out.write(attachment.getAttachmentContent());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}