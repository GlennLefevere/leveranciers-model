/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import be.provikmo.leveranciers.model.Artikel;
import be.provikmo.leveranciers.model.Leverancier;
import be.provikmo.leveranciers.model.Leverancier_;
import be.provikmo.leveranciers.repositories.LeveranciersRepository;
import be.provikmo.leveranciers.services.api.LeverancierService;

/**
 * @author Glenn Lefevere
 *
 */
@Repository
@Transactional(readOnly = true)
public class LeverancierServiceImpl implements LeverancierService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private LeveranciersRepository leveranciersRepository;

	public List<Leverancier> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Leverancier> cq = cb.createQuery(Leverancier.class).distinct(true);
		Root<Leverancier> root = cq.from(Leverancier.class);

		cq.orderBy(cb.asc(root.get(Leverancier_.naam)));

		cq.select(root);

		TypedQuery<Leverancier> query = em.createQuery(cq);

		return query.getResultList();
	}

	public Leverancier findById(String id) {
		return leveranciersRepository.findOne(id);
	}

	public Leverancier save(Leverancier leverancier) {
		em.persist(leverancier);
		em.flush();

		return leverancier;
	}

	public Leverancier findByIdJoinArtikel(String id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Leverancier> cq = cb.createQuery(Leverancier.class).distinct(true);
		Root<Leverancier> root = cq.from(Leverancier.class);

		root.fetch(Leverancier_.artikels, JoinType.LEFT);

		cq.where(cb.equal(root.get(Leverancier_.id), id));

		TypedQuery<Leverancier> query = em.createQuery(cq);

		List<Leverancier> results = query.getResultList();

		Leverancier result = null;

		if (!CollectionUtils.isEmpty(results)) {
			result = results.get(0);
		}

		return result;
	}

	public Leverancier update(Leverancier leverancier) {
		return leveranciersRepository.saveAndFlush(leverancier);
	}

	public List<Leverancier> findByNaam(String filter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Leverancier> cq = cb.createQuery(Leverancier.class).distinct(true);
		Root<Leverancier> root = cq.from(Leverancier.class);

		cq.where(cb.like(root.get(Leverancier_.naam), "%" + filter + "%"));

		cq.orderBy(cb.asc(root.get(Leverancier_.naam)));

		TypedQuery<Leverancier> query = em.createQuery(cq);

		return query.getResultList();
	}

	public void addArtikelToLeverancier(String id, Artikel artikel) {
		Leverancier leverancier = findByIdJoinArtikel(id);
		leverancier.getArtikels().add(artikel);
		update(leverancier);

	}

}
