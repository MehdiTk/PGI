package model;
// Generated 4 juil. 2016 00:52:55 by Hibernate Tools 3.6.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Equipement.
 * @see model.Equipement
 * @author Hibernate Tools
 */
public class EquipementHome {

	private static final Log log = LogFactory.getLog(EquipementHome.class);


	private final Session session = HibernateUtil.getSessionFactory().openSession();


	public void persist(Equipement transientInstance) {
		log.debug("persisting Equipement instance");
		try {
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Equipement instance) {
		log.debug("attaching dirty Equipement instance");
		try {
			session.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Equipement instance) {
		log.debug("attaching clean Equipement instance");
		try {
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Equipement persistentInstance) {
		log.debug("deleting Equipement instance");
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Equipement merge(Equipement detachedInstance) {
		log.debug("merging Equipement instance");
		try {
			Equipement result = (Equipement) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Equipement findById(java.lang.String id) {
		log.debug("getting Equipement instance with id: " + id);
		try {
			Equipement instance = (Equipement) session.get("model.Equipement", id);
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

	public List<Equipement> findByExample(Equipement instance) {
		log.debug("finding Equipement instance by example");
		try {
			List<Equipement> results = (List<Equipement>) session
					.createCriteria("model.Equipement").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Equipement> findEquipement(String instance) {
		log.debug("finding Contrat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Equipement> results = (List<Equipement>) session.createCriteria("model.Equipement")
					.add( Restrictions.like("equipementEmpcrea",instance) )
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Equipement> GetAll() {
		log.debug("finding Contrat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Equipement> results = (List<Equipement>) session.createCriteria("model.Equipement").list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
