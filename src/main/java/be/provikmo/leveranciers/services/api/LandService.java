/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.api;

import org.springframework.stereotype.Service;

import be.provikmo.leveranciers.model.Land;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface LandService {

	Land saveOrUpdate(Land gemeente);

}
