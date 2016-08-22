package model;
// Generated 4 juil. 2016 00:52:55 by Hibernate Tools 3.6.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.CacheMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistryBuilder;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Etatserveur.
 * @see model.Etatserveur
 * @author Hibernate Tools
 */
public class EtatserveurHome {

	private static final Log log = LogFactory.getLog(EtatserveurHome.class);

	  private String urlip;

	
	  private static SessionFactory sessionfty = HibernateUtil.getSessionFactory();
	  
	  
	    /*public EtatserveurHome(String ip) {
			setUrlip(ip);
			 Configuration configuration = new Configuration().configure().setProperty("hibernate.connection.url", "jdbc:oracle:thin:@"+ getUrlip()+ ":1521:ORCL");
	 		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
	                 .applySettings(configuration.getProperties()); 
	 		sessionfty =  configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
			
		}*/


	   
	    public void persist(Etatserveur transientInstance) {
	   	 Transaction trns = null;
	   	Session session = sessionfty.openSession();
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



		public String getUrlip() {
			return urlip;
		}



		public void setUrlip(String urlip) {
			this.urlip = urlip;
		}
	
	
	
		 public List datachart() {
		        log.debug("finding SfeCpuUsage instance by example");
		        Session session = sessionfty.openSession();
		        try {
		        	
		        	session.setCacheMode(CacheMode.IGNORE);
		        	List results = session.createCriteria("model.Etatserveur")
		        			.add(Restrictions.sqlRestriction("1=1 order by 1 desc")).setMaxResults(10).list();
		            log.debug("find by example successful, result size: " + results.size());
		            return results;
		        }
		        catch (RuntimeException re) {
		            log.error("find by example failed", re);
		            throw re;
		        } finally {
		            session.flush();
		            session.close();
		        }
		    } 
		    
		    public List datachartlast() {
		        log.debug("finding SfeCpuUsage instance by example");
		        Session session = sessionfty.openSession();
		        try {
		        	
		        	session.setCacheMode(CacheMode.IGNORE);
		        	List results = session.createCriteria("model.Etatserveur")
		        			.add(Restrictions.sqlRestriction("1=1 order by 1 desc")).setMaxResults(1).list();
		            log.debug("find by example successful, result size: " + results.size());
		            return results;
		        }
		        catch (RuntimeException re) {
		            log.error("find by example failed", re);
		            throw re;
		        } finally {
		            session.flush();
		            session.close();
		        }
		    } 
	
	
	
	
	
/*
	public void persist(Etatserveur transientInstance) {
		log.debug("persisting Etatserveur instance");
		try {
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Etatserveur instance) {
		log.debug("attaching dirty Etatserveur instance");
		try {
			session.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Etatserveur instance) {
		log.debug("attaching clean Etatserveur instance");
		try {
			session.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Etatserveur persistentInstance) {
		log.debug("deleting Etatserveur instance");
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Etatserveur merge(Etatserveur detachedInstance) {
		log.debug("merging Etatserveur instance");
		try {
			Etatserveur result = (Etatserveur) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Etatserveur findById(java.lang.String id) {
		log.debug("getting Etatserveur instance with id: " + id);
		try {
			Etatserveur instance = (Etatserveur) session.get("model.Etatserveur", id);
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

	public List<Etatserveur> findByExample(Etatserveur instance) {
		log.debug("finding Etatserveur instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Etatserveur> results = (List<Etatserveur>) session
					.createCriteria("model.Etatserveur").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}*/
}
