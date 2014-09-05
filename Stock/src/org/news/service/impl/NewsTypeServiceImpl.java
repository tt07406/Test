/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsTypeService
 * 
 * �������ڣ�2014-06-20
 */
package org.news.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.news.dao.NewsTypeDAO;
import org.news.model.NewsInfo;
import org.news.model.NewsType;
import org.news.service.NewsInfoService;
import org.news.service.NewsTypeService;

/**
 * �������ͷ�����
 * @author tt
 * @version 14.6.18
 */
public class NewsTypeServiceImpl implements NewsTypeService {
	private NewsTypeDAO newsTypeDAO; //����������ϢDAO
	private NewsInfoService infoService;
	
	
	/**
	 * @param newsTypeDAO the newsTypeDAO to set
	 */
	public void setNewsTypeDAO(NewsTypeDAO newsTypeDAO) {
		this.newsTypeDAO = newsTypeDAO;
	}

	/**
	 * @param infoService the infoService to set
	 */
	public void setInfoService(NewsInfoService infoService) {
		this.infoService = infoService;
	}

	/**
	 * ���Ƶ��
	 * @param type
	 * @param description
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addNewsType(String type, String description){
		if (findNewsTypeName(type)){//�ظ�����֤
			return false;
		}

		boolean flag = true;//��־
		List<NewsType> typeSet = getAllNewsType();//��ȡ��ǰ����Ƶ��
		int newsTypeId;//Ƶ��ID
		if (typeSet.size() == 0){
			newsTypeId = 1;
		}else{
			newsTypeId = typeSet.get(typeSet.size()-1).getNewsTypeId()+1;
		}
		
		NewsType newstype = new NewsType(newsTypeId, type, description);
		if (!newsTypeDAO.addNewsType(newstype)){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * ɾ����������
	 * @param index
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteNewsType(int index) {
		ArrayList<Integer> newsTypeIds = new ArrayList<Integer>(); //Ҫɾ����Ƶ��ID
		newsTypeIds.add(new Integer(index));
		String newsType = getNewsTypeById(index).getNewsTypeName();
		
		if(newsTypeDAO.deleteNewsType(newsTypeIds)){
			List<NewsInfo> newsInfos = infoService.getAllNewsInfoByType(newsType);//�õ����и�������
			if (newsInfos.size() == 0){//û��������ɹ�
				return true;
			}
			//ɾ�������������
			int [] newsInfoIds = new int[newsInfos.size()];
			for (int i = 0; i<newsInfoIds.length; ++i){
				newsInfoIds[i] = newsInfos.get(i).getNewsInfoId();
			}
			return infoService.deleteNewsInfo(newsInfoIds);
		}else {
			return false;
		}
			
	}
	
	/**
	 * �޸�Ƶ����Ϣ
	 * @param NewsType
	 * @return �Ƿ�ɹ�
	 */
	public boolean updateNewsType(NewsType newsType) {
		if (newsTypeDAO.updateNewsType(newsType) == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	* ��ѯ���е�Ƶ����Ϣ
	* @return Ƶ������
	*/
	 public List<NewsType> getAllNewsType(){
		 return newsTypeDAO.getAllNewsType();
	}

	/**
	 * ����ID���ҵ���Ӧ�����
	 * @param typeid
	 * @return
	 */
	public NewsType getNewsTypeById(int typeid){
		return newsTypeDAO.findNewsTypeById(typeid);
	}

	/**
	 * ���������ҵ���Ӧ�����
	 * @param name
	 * @return
	 */
	public boolean findNewsTypeName(String name){
		if (newsTypeDAO.findNewsTypeByName(name) == null){
			return false;
		}else {
			return true;
		}
			
	}
}
