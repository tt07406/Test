/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsTypeServiceImpl
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mystock.dao.NewsTypeHibernateDAO;
import org.mystock.model.NewsInfo;
import org.mystock.model.NewsType;
import org.mystock.service.NewsInfoService;
import org.mystock.service.NewsTypeService;

/**
 * �������ͷ�����
 * @author tt
 * @version 14.9.16
 */
public class NewsTypeServiceImpl implements NewsTypeService {
	private NewsTypeHibernateDAO newsTypeDAO; //����������ϢDAO
	private NewsInfoService infoService;
	
	
	/**
	 * @param newsTypeDAO the newsTypeDAO to set
	 */
	public void setNewsTypeDAO(NewsTypeHibernateDAO newsTypeDAO) {
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
	
	/**
     * ���ݵ����ݿ�
     */
    public void backup(SessionFactory sf){
    	List<NewsType> types = getAllNewsType();
    	Session session = null;
    	Transaction tx = null;
   		
   		//�Ȼ��տռ�
   		try {
   			session = sf.openSession();
			tx = session.beginTransaction();
			session.createSQLQuery("truncate table newstype").executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
   				if (session.isOpen()) {
   					session.close(); // �ر�Session
   				}
   			}
		}

		try{			
			session = sf.openSession();
			//��ʼ����
			Transaction t=session.beginTransaction();
			
			//������������
			for (int i = 0; i< types.size(); ++i){
				session.save(types.get(i));
				// ������Ķ�������д�����ݿⲢ�ͷ��ڴ�
				if (i % 10 == 0) {
					session.flush();
					session.clear();
				}
			}
			
			//�ύ����
			t.commit();
			System.out.println("end backup..");
		}catch (Exception e) {
			e.printStackTrace(); // ��ӡ������Ϣ
			session.getTransaction().rollback(); // �����ع�����
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					session.close(); // �ر�Session
				}
			}
		}
	}
}
