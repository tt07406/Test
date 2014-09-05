/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AttachmentService
 * 
 * �������ڣ�2014-07-02
 */
package org.news.service;

import java.util.List;

import org.news.model.NewsAttachment;

/**
 * ����������ӿ�
 * @author tt
 * @version 14.6.18
 */
public interface AttachmentService {
;
	/**
     * ��ͨ��Id�����Ҹ�������Ϣ
     * @param attachmentId
     * @return
     */
    public NewsAttachment findNewsAttachmentById(long attachmentId);
    
    /**
     * ��ͨ��NewsId�����Ҹ�������Ϣ
     * @param newsId
     * @return
     */
    public List<NewsAttachment> findNewsAttachmentByNewsId(long newsId);
   
    /**
     * ���Ӹ���
     * @param newsAttachment
     * @return
     */
    public boolean addNewsAttachment(NewsAttachment newsAttachment);
    
    /**
     * ɾ������
     * @param newsid
     * @return
     */
    public boolean deleteAttachment(int attachmentid);
    
    /**
  	  * ģ����ѯ���
  	  * @param keyword �ؼ���
     * @param currentPage ��ǰҳ
     * @param lineSize ÿҳ��С
     * @return �������
     */
     public List<NewsAttachment> getAllSoftwares(String keyword, int currentPage, int lineSize);
     
     /**
      * ��ѯ���йؼ��ֵ��������
      * @param keyword
      * @return �������
      */
     public long getCount(String keyword);
     
     /**
      * ɾ�������ļ�
      * @param   sPath    ��ɾ���ļ����ļ���
      * @return �����ļ�ɾ���ɹ�����true�����򷵻�false
      */
     public boolean deleteFile(String sPath);
}
