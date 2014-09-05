/*
 * 系统名称：新闻发布系统
 * 
 * 类名：AttachmentService
 * 
 * 创建日期：2014-07-02
 */
package org.news.service;

import java.util.List;

import org.news.model.NewsAttachment;

/**
 * 附件服务类接口
 * @author tt
 * @version 14.6.18
 */
public interface AttachmentService {
;
	/**
     * 可通过Id来查找附件的信息
     * @param attachmentId
     * @return
     */
    public NewsAttachment findNewsAttachmentById(long attachmentId);
    
    /**
     * 可通过NewsId来查找附件的信息
     * @param newsId
     * @return
     */
    public List<NewsAttachment> findNewsAttachmentByNewsId(long newsId);
   
    /**
     * 增加附件
     * @param newsAttachment
     * @return
     */
    public boolean addNewsAttachment(NewsAttachment newsAttachment);
    
    /**
     * 删除附件
     * @param newsid
     * @return
     */
    public boolean deleteAttachment(int attachmentid);
    
    /**
  	  * 模糊查询软件
  	  * @param keyword 关键字
     * @param currentPage 当前页
     * @param lineSize 每页大小
     * @return 软件集合
     */
     public List<NewsAttachment> getAllSoftwares(String keyword, int currentPage, int lineSize);
     
     /**
      * 查询含有关键字的软件数量
      * @param keyword
      * @return 软件数量
      */
     public long getCount(String keyword);
     
     /**
      * 删除单个文件
      * @param   sPath    被删除文件的文件名
      * @return 单个文件删除成功返回true，否则返回false
      */
     public boolean deleteFile(String sPath);
}
