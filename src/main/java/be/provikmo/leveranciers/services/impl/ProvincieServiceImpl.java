/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.provikmo.leveranciers.model.Provincie;
import be.provikmo.leveranciers.services.api.ProvincieService;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
@Transactional(readOnly = true)
public class ProvincieServiceImpl implements ProvincieService {

	@PersistenceContext
	private EntityManager em;

	/** {@inheritDoc} */
	@Override
	@Transactional
	public Provincie saveOrUpdate(Provincie gemeente) {
		em.persist(gemeente);
		em.flush();
		return gemeente;
	}

}
