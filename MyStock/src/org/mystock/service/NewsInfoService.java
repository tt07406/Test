/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsInfoService
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service;

import java.io.IOException;
import java.util.List;

import org.mystock.model.NewsIndex;
import org.mystock.model.NewsInfo;
import org.mystock.model.NewsVO;

/**
 * ������Ϣ������ӿ�
 * @author tt
 * @version 14.9.16
 */
public interface NewsInfoService {

	/**
	 * ������ŷ���
	 * @param newsInfo
	 * @return �����Ƿ�ɹ�
	 * @throws IOException 
	 */
	public boolean addNewsInfo(NewsInfo newsInfo);
	
	/**
	 * ����ɾ������
	 * @param newsInfoIds
	 * @return
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds);
	
	/**
	 * ��ѯ�������ݷ���
	 * @param newsInfoId
	 * @return
	 */
	public NewsInfo searchNewsInfo(int newsInfoId);
	
	/**
	 * �޸�������Ϣ����
	 * @param newsInfo
	 * @return
	 * @throws IOException 
	 */
	public boolean updateNewsInformation(NewsInfo newsInfo);
	
	/**
	 * ��ѯ���е�������Ϣ
	 * @return ���ż���
	 */
     public List<NewsInfo> getAllNewsInfo();
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword
      * @return ���ż���
      */
     public List<NewsInfo> getAllNewsInfo(String keyword);
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword �ؼ���
      * @param currentPage ��ǰҳ
      * @param lineSize ÿҳ��С
      * @return ���ż���
      */
     public List<NewsInfo> getAllNewsInfo(String keyword, int currentPage, int lineSize);
     
     /**
  	 * �����������Ͳ�ѯ����ص�����
  	 * @param newsType 
  	 * @return ���ż���
  	 */
       public List<NewsInfo> getAllNewsInfoByType(String newsType);
       
       /**
     	 * �����������Ͳ�ѯ����ص�����
     	 * @param newsType 
     	 * @param currentPage ��ǰҳ
     	 * @param lineSize ÿҳ��С
     	 * @return ���ż���
     	 */
          public List<NewsInfo> getAllNewsInfoByType(String newsType, int currentPage, int lineSize);
       
       /**
        * ��ȡ��ѯ���������
        * @param keyword
        * @return
        */
       public long getAllCount(String keyword);
       
       /**
        * �����ŵ�POת����VO����ʾ
        * @param newsInfo
        * @return
        */
       public NewsVO toNewsVO(NewsInfo newsInfo);
       
       /**
        * �����ŵ�POת��������VO����ʾ
        * @param newsInfo
        * @return
        */
       public NewsIndex toNewsIndex(NewsInfo newsInfo);

       /**
        * ���ݵ����ݿ�
        */
       public void backup();
}
