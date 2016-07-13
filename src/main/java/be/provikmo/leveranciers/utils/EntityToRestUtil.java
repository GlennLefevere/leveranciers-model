/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.utils;

import java.util.ArrayList;

import org.springframework.util.CollectionUtils;

import be.provikmo.leveranciers.model.Artikel;
import be.provikmo.leveranciers.model.Leverancier;
import be.provikmo.leveranciers.model.rest.ArtikelRest;
import be.provikmo.leveranciers.model.rest.LeverancierRest;

/**
 * @author Glenn Lefevere
 *
 */
public final class EntityToRestUtil {

	private EntityToRestUtil() {
	}

	public static LeverancierRest leverancierToLeverancierRest(Leverancier leverancier) {
		LeverancierRest result = new LeverancierRest();

		result.setId(leverancier.getId());
		result.setNaam(leverancier.getNaam());
		result.setTelefoon(leverancier.getTelefoon());
		result.setFax(leverancier.getFax());
		result.setEmail(leverancier.getEmail());
		result.setWebsite(leverancier.getWebsite());
		result.setLatitude(leverancier.getLatitude());
		result.setLongitude(leverancier.getLongitude());
		result.setWebshop(leverancier.getWebshop());

		result.setAdres(leverancier.getAdres());

		if (!CollectionUtils.isEmpty(leverancier.getArtikels())) {
			leverancier.getArtikels().forEach(a -> a.setLeveranciers(new ArrayList<>()));

			result.setArtikels(leverancier.getArtikels());
		}

		return result;
	}

	public static ArtikelRest artikelToArtikelRest(Artikel artikel) {
		ArtikelRest result = new ArtikelRest();

		result.setId(artikel.getId());

		result.setOmschrijving(artikel.getOmschrijving());

		if (!CollectionUtils.isEmpty(artikel.getLeveranciers())) {
			artikel.getLeveranciers().forEach(l -> l.setArtikels(new ArrayList<>()));

			result.setLeveranciers(artikel.getLeveranciers());
		}

		return result;
	}

}
