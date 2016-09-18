/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.api;

import org.springframework.stereotype.Service;

import be.provikmo.leveranciers.model.Gemeente;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface GemeenteService {

	Gemeente saveOrUpdate(Gemeente gemeente);

}
