package model;
// Generated 4 juil. 2016 00:52:55 by Hibernate Tools 3.6.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Entreprise.
 * @see model.Entreprise
 * @author Hibernate Tools
 */
public class EntrepriseHome {

	private static final Log log = LogFactory.getLog(EntrepriseHome.class);

	private final Session session = HibernateUtil.getSessionFactory().openSession();

	public void persist(Entreprise transientInstance) {
		log.debug("persisting Entreprise instance");
		try {
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Entreprise instance) {
		log.debug("attaching dirty Entreprise instance");
		try {
			session.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Entreprise instance) {
		log.debug("attaching clean Entreprise instance");
		try {
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Entreprise persistentInstance) {
		log.debug("deleting Entreprise instance");
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Entreprise merge(Entreprise detachedInstance) {
		log.debug("merging Entreprise instance");
		try {
			Entreprise result = (Entreprise) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Entreprise findById(java.lang.String id) {
		log.debug("getting Entreprise instance with id: " + id);
		try {
			Entreprise instance = (Entreprise) session.get("model.Entreprise", id);
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

	public List<Entreprise> findByExample(Entreprise instance) {
		log.debug("finding Entreprise instance by example");
		try {
			List<Entreprise> results = (List<Entreprise>) session
					.createCriteria("model.Entreprise").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Entreprise> findall() {
		log.debug("finding Entreprise instance by example");
		try {
			List<Entreprise> results = (List<Entreprise>) session
					.createCriteria("model.Entreprise").list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
}
