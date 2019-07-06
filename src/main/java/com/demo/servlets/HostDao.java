package com.demo.servlets;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.demo.entities.Host;

@Stateless
public class HostDao {

	// Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    public void persist(Host host) {
        em.persist(host);
    }

    // Retrieves all the guests:
    public List<Host> getAllHosts() {
        TypedQuery<Host> query = em.createQuery(
            "SELECT h FROM Host h ORDER BY h.id", Host.class);
        return query.getResultList();
    }
}
