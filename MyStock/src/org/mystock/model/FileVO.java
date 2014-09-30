/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：FileVO
 * 
 * 创建日期：2014-09-30
 */
package org.mystock.model;

import java.util.Date;

/**
 * 文件信息的VO类
 * 
 * @author tt
 * @version 14.9.16
 */
public class FileVO {

	String filename;//文件名
	long size;//文件大小，字节
	Date modifyTime;//修改时间
	
	public FileVO(){}

	public FileVO(String filename, long size, Date modifyTime) {
		super();
		this.filename = filename;
		this.size = size;
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	};
	
	
}
