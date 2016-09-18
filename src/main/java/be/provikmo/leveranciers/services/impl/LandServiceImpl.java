/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.provikmo.leveranciers.model.Land;
import be.provikmo.leveranciers.services.api.LandService;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
@Transactional(readOnly = true)
public class LandServiceImpl implements LandService {

	@PersistenceContext
	private EntityManager em;

	/** {@inheritDoc} */
	@Override
	@Transactional
	public Land saveOrUpdate(Land gemeente) {
		em.persist(gemeente);
		em.flush();
		return gemeente;
	}

}
