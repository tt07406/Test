package org.news.hibernate.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.news.hibernate.domain.Leavemessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Leavemessage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.news.hibernate.dao.Leavemessage
 * @author MyEclipse Persistence Tools
 */

public class LeavemessageDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LeavemessageDAO.class);
	// property constants
	public static final String LEAVE_MESSAGE_CONTENT = "leaveMessageContent";

	public void save(Leavemessage transientInstance) {
		log.debug("saving Leavemessage instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Leavemessage persistentInstance) {
		log.debug("deleting Leavemessage instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Leavemessage findById(java.lang.Integer id) {
		log.debug("getting Leavemessage instance with id: " + id);
		try {
			Leavemessage instance = (Leavemessage) getSession().get(
					"org.news.hibernate.dao.Leavemessage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Leavemessage instance) {
		log.debug("finding Leavemessage instance by example");
		try {
			List results = getSession().createCriteria(
					"org.news.hibernate.dao.Leavemessage").add(
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
		log.debug("finding Leavemessage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Leavemessage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLeaveMessageContent(Object leaveMessageContent) {
		return findByProperty(LEAVE_MESSAGE_CONTENT, leaveMessageContent);
	}

	public List findAll() {
		log.debug("finding all Leavemessage instances");
		try {
			String queryString = "from Leavemessage";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Leavemessage merge(Leavemessage detachedInstance) {
		log.debug("merging Leavemessage instance");
		try {
			Leavemessage result = (Leavemessage) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Leavemessage instance) {
		log.debug("attaching dirty Leavemessage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Leavemessage instance) {
		log.debug("attaching clean Leavemessage instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}