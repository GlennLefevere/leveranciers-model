/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.api;

import java.util.List;

import org.springframework.stereotype.Service;

import be.provikmo.leveranciers.model.Leverancier;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface LeverancierService {

	List<Leverancier> findAll();

	Leverancier findById(Long id);

	Leverancier save(Leverancier leverancier);

	Leverancier findByIdJoinArtikel(Long id);

	List<Leverancier> findByNaam(String query);
}
