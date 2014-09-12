package org.news.hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.news.hibernate.domain.NewsAttachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * NewsAttachment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.news.hibernate.dao.NewsAttachment
 * @author MyEclipse Persistence Tools
 */

public class NewsAttachmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NewsAttachmentDAO.class);
	// property constants
	public static final String NEWS_ID = "newsId";
	public static final String ATTACHMENT_NAME = "attachmentName";
	public static final String ATTACHMENT_CONTENT = "attachmentContent";

	public void save(NewsAttachment transientInstance) {
		log.debug("saving NewsAttachment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewsAttachment persistentInstance) {
		log.debug("deleting NewsAttachment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewsAttachment findById(java.lang.Integer id) {
		log.debug("getting NewsAttachment instance with id: " + id);
		try {
			NewsAttachment instance = (NewsAttachment) getSession().get(
					"org.news.hibernate.domain.NewsAttachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NewsAttachment instance) {
		log.debug("finding NewsAttachment instance by example");
		try {
			List results = getSession().createCriteria(
					"org.news.hibernate.domain.NewsAttachment").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding NewsAttachment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from NewsAttachment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNewsId(Object newsId) {
		return findByProperty(NEWS_ID, newsId);
	}

	public List findByAttachmentName(Object attachmentName) {
		return findByProperty(ATTACHMENT_NAME, attachmentName);
	}

	public List findByAttachmentContent(Object attachmentContent) {
		return findByProperty(ATTACHMENT_CONTENT, attachmentContent);
	}

	public List findAll() {
		log.debug("finding all NewsAttachment instances");
		try {
			String queryString = "from NewsAttachment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewsAttachment merge(NewsAttachment detachedInstance) {
		log.debug("merging NewsAttachment instance");
		try {
			NewsAttachment result = (NewsAttachment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewsAttachment instance) {
		log.debug("attaching dirty NewsAttachment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewsAttachment instance) {
		log.debug("attaching clean NewsAttachment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}