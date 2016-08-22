package model2;
// Generated 31 mai 2016 17:50:06 by Hibernate Tools 4.3.1.Final


import java.util.List;
import javax.naming.InitialContext;
import javax.persistence.criteria.Order;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.CacheMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

/**
 * Home object for domain model class SfeCpuUsage.
 * @see model2.SfeCpuUsage
 * @author Hibernate Tools
 */
public class SfeCpuUsageHome {

    private static final Log log = LogFactory.getLog(SfeCpuUsageHome.class);

    private final Session session =  HibernateUtil.getSessionFactory().openSession();;
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(SfeCpuUsage transientInstance) {
    	 Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            session.save(transientInstance);
	            session.getTransaction().commit();
	        } catch (RuntimeException e) {
	            if (trns != null) {
	                trns.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
    }
    
    public void attachDirty(SfeCpuUsage instance) {
        log.debug("attaching dirty SfeCpuUsage instance");
        try {
            session.saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SfeCpuUsage instance) {
        log.debug("attaching clean SfeCpuUsage instance");
        try {
            session.lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(SfeCpuUsage persistentInstance) {
        log.debug("deleting SfeCpuUsage instance");
        try {
            session.delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SfeCpuUsage merge(SfeCpuUsage detachedInstance) {
        log.debug("merging SfeCpuUsage instance");
        try {
            SfeCpuUsage result = (SfeCpuUsage) session
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SfeCpuUsage findById( model2.SfeCpuUsageId id) {
        log.debug("getting SfeCpuUsage instance with id: " + id);
        try {
            SfeCpuUsage instance = (SfeCpuUsage) session
                    .get("model.SfeCpuUsage", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List findByExample(SfeCpuUsage instance) {
        log.debug("finding SfeCpuUsage instance by example");
        try {
            List results = session
                    .createCriteria("model.SfeCpuUsage")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
    public List findALL() {
        log.debug("finding SfeCpuUsage instance by example");
        try {
            List results = session
                    .createCriteria("model.SfeCpuUsage")
                    .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
    
    public List datachart() {
        log.debug("finding SfeCpuUsage instance by example");
        try {
        	session.setCacheMode(CacheMode.IGNORE);
        	List results = session.createCriteria("model.SfeCpuUsage")
        			.add(Restrictions.sqlRestriction("1=1 order by 1 desc")).setMaxResults(10).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
    
    public List datachartlast() {
        log.debug("finding SfeCpuUsage instance by example");
        try {
        	session.setCacheMode(CacheMode.IGNORE);
        	List results = session.createCriteria("model.SfeCpuUsage")
        			.add(Restrictions.sqlRestriction("1=1 order by 1 desc")).setMaxResults(1).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
    
    
    
}

