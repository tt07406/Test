/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsTypeService
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service;

import java.util.List;

import org.mystock.model.NewsType;

/**
 * �������ͷ�����ӿ�
 * @author tt
 * @version 14.9.16
 */
public interface NewsTypeService {
	
	/**
	 * ���Ƶ��
	 * @param type
	 * @param description
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addNewsType(String type, String description);
	
	/**
	 * ɾ����������
	 * @param index
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteNewsType(int index);
	
	/**
	 * �޸�Ƶ����Ϣ
	 * @param NewsType
	 * @return �Ƿ�ɹ�
	 */
	public boolean updateNewsType(NewsType newsType) ;
	
	/**
	* ��ѯ���е�Ƶ����Ϣ
	* @return Ƶ������
	*/
	 public List<NewsType> getAllNewsType();

	/**
	 * ����ID���ҵ���Ӧ�����
	 * @param typeid
	 * @return
	 */
	public NewsType getNewsTypeById(int typeid);

	/**
	 * ���������ҵ���Ӧ�����
	 * @param name
	 * @return
	 */
	public boolean findNewsTypeName(String name);
}
