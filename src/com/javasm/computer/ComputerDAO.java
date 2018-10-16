package com.javasm.computer;

import com.javasm.base.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Computer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.javasm.computer.Computer
  * @author MyEclipse Persistence Tools 
 */
public class ComputerDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ComputerDAO.class);
	

    
    public void save(Computer transientInstance) {
        log.debug("saving Computer instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Computer persistentInstance) {
        log.debug("deleting Computer instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Computer findById( java.lang.Integer id) {
        log.debug("getting Computer instance with id: " + id);
        try {
            Computer instance = (Computer) getSession()
                    .get("com.javasm.computer.Computer", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Computer> findByExample(Computer instance) {
        log.debug("finding Computer instance by example");
        try {
            List<Computer> results = (List<Computer>) getSession()
                    .createCriteria("com.javasm.computer.Computer")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Computer instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Computer as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all Computer instances");
		try {
			String queryString = "from Computer";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Computer merge(Computer detachedInstance) {
        log.debug("merging Computer instance");
        try {
            Computer result = (Computer) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Computer instance) {
        log.debug("attaching dirty Computer instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Computer instance) {
        log.debug("attaching clean Computer instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}