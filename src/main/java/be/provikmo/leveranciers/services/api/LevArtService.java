package be.provikmo.leveranciers.services.api;

import org.springframework.stereotype.Service;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface LevArtService {

	void deleteById(Long id);
}
