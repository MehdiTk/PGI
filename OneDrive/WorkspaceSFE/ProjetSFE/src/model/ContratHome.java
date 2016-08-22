package model;
// Generated 4 juil. 2016 00:52:55 by Hibernate Tools 3.6.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Contrat.
 * @see model.Contrat
 * @author Hibernate Tools
 */
public class ContratHome {

	private static final Log log = LogFactory.getLog(ContratHome.class);

	private final Session session = HibernateUtil.getSessionFactory().openSession();
	

	/*public void persist(Contrat transientInstance) {
		log.debug("persisting Contrat instance");
		try {
			session.persist(transientInstance);
			session.getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}*/

	  public void persist(Contrat transientInstance) {
		   	 Transaction trns = null;
		   
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

	public void attachDirty(Contrat instance) {
		log.debug("attaching dirty Contrat instance");
		try {
			session.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contrat instance) {
		log.debug("attaching clean Contrat instance");
		try {
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Contrat persistentInstance) {
		log.debug("deleting Contrat instance");
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contrat merge(Contrat detachedInstance) {
		log.debug("merging Contrat instance");
		try {
			Contrat result = (Contrat) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Contrat findById(java.lang.String id) {
		log.debug("getting Contrat instance with id: " + id);
		try {
			Contrat instance = (Contrat) session.get("model.Contrat", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Contrat> findContrat(String instance) {
		log.debug("finding Contrat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Contrat> results = (List<Contrat>) session.createCriteria("model.Contrat")
					.add( Restrictions.like("contratEmpcrea",instance) )
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Contrat> GetAll() {
		log.debug("finding Contrat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Contrat> results = (List<Contrat>) session.createCriteria("model.Contrat").list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
