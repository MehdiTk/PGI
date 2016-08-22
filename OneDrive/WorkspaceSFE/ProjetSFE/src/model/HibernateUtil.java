package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    @SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
        try {
        	
        		  Configuration configuration = new Configuration().configure();
        		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()); 
                return configuration.buildSessionFactory(serviceRegistryBuilder
                        .buildServiceRegistry());
        	
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
 
        return sessionFactory;
    }
}