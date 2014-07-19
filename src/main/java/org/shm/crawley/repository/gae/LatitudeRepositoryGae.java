package org.shm.crawley.repository.gae;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.shm.crawley.domain.Latitude;
import org.shm.crawley.repository.LatitudeRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class LatitudeRepositoryGae implements LatitudeRepository{
	
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Latitude create(Latitude o) {

		try {
			em.persist(o);
		} finally {
			em.close();
		}

		return o;
	}

	public void saveOrUpdate(Latitude o) {
			em.merge(o);
	}

	public Latitude read(Long id) {
		return em.find(Latitude.class,id);
	}

	public void update(Latitude o) {
		em.merge(o);
	}

	public void delete(Latitude o) {
		em.remove(o);
	}

	public int deleteById(Long id) {

		String find = "delete From Latitude t where id= :id";
		Query query = em.createQuery(find);
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	/**
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	public Latitude findById(Long id) {
		return  em.find(Latitude.class, id);
	}

}
