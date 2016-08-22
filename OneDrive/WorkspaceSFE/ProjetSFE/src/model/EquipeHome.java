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
 * Home object for domain model class Equipe.
 * @see model.Equipe
 * @author Hibernate Tools
 */
public class EquipeHome {

	private static final Log log = LogFactory.getLog(EquipeHome.class);

	private final Session session = HibernateUtil.getSessionFactory().openSession();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Equipe transientInstance) {
		log.debug("persisting Equipe instance");
		try {
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Equipe instance) {
		log.debug("attaching dirty Equipe instance");
		try {
			session.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Equipe instance) {
		log.debug("attaching clean Equipe instance");
		try {
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Equipe persistentInstance) {
		log.debug("deleting Equipe instance");
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Equipe merge(Equipe detachedInstance) {
		log.debug("merging Equipe instance");
		try {
			Equipe result = (Equipe) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Equipe findById(java.lang.String id) {
		log.debug("getting Equipe instance with id: " + id);
		try {
			Equipe instance = (Equipe) session.get("model.Equipe", id);
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

	public List<Equipe> findByExample(Equipe instance) {
		log.debug("finding Equipe instance by example");
		try {
			List<Equipe> results = (List<Equipe>) session.createCriteria("model.Equipe")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Equipe> findEquipe(String instance) {
		log.debug("finding Contrat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Equipe> results = (List<Equipe>) session.createCriteria("model.Equipe")
					.add( Restrictions.like("contratEmpcrea",instance) )
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Equipe> GetAll() {
		log.debug("finding Contrat instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Equipe> results = (List<Equipe>) session.createCriteria("model.Equipe").list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
