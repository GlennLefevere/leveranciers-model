/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.provikmo.leveranciers.model.Gemeente;
import be.provikmo.leveranciers.services.api.GemeenteService;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
@Transactional(readOnly = true)
public class GemeenteServiceImpl implements GemeenteService {

	@PersistenceContext
	private EntityManager em;

	/** {@inheritDoc} */
	@Override
	@Transactional
	public Gemeente saveOrUpdate(Gemeente gemeente) {
		em.persist(gemeente);
		em.flush();

		return gemeente;
	}

}
