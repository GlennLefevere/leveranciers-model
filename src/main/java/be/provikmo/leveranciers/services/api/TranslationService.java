/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.services.api;

import org.springframework.stereotype.Service;

import be.provikmo.leveranciers.model.Translation;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface TranslationService {

	Translation findTranslation(String key, String locale);

	Translation saveTransLation(Translation translation);
}
