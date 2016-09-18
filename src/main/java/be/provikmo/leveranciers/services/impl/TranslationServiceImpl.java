/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.provikmo.leveranciers.model.Translation;
import be.provikmo.leveranciers.model.Translation_;
import be.provikmo.leveranciers.services.api.TranslationService;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
@Transactional(readOnly = true)
public class TranslationServiceImpl implements TranslationService {

	@PersistenceContext
	private EntityManager em;

	/** {@inheritDoc} */
	@Override
	public Translation findTranslation(String key, String locale) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Translation> cq = cb.createQuery(Translation.class).distinct(true);
		Root<Translation> root = cq.from(Translation.class);

		Predicate p =
			cb.and(cb.equal(root.get(Translation_.locale), locale), cb.equal(root.get(Translation_.waarde), key));

		cq.where(p);

		return em.createQuery(cq).getSingleResult();
	}

	/** {@inheritDoc} */
	@Override
	@Transactional
	public Translation saveTransLation(Translation translation) {
		em.persist(translation);
		em.flush();
		return translation;
	}

}
