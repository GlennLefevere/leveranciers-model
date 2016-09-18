/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.api;

import java.util.List;

import org.springframework.stereotype.Service;

import be.provikmo.leveranciers.model.Artikel;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface ArtikelService {

	Artikel findById(String id);

	List<Artikel> findAll();

	List<Artikel> findAllJoinLeveranciers();

	Artikel save(Artikel artikel);

	List<Artikel> save(List<Artikel> artikels);

	Artikel findByIdJoinLeveranciers(String id);

	List<Artikel> findByOmschrijving(String query);
}
