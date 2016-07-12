/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import be.provikmo.leveranciers.model.Artikel;
import be.provikmo.leveranciers.model.LevArt;
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

		if (!CollectionUtils.isEmpty(leverancier.getLevArts())) {
			result.setArtikels(leverancier.getLevArts().stream()
				.filter(la -> la.getArtikel() != null)
				.map(LevArt::getArtikel)
				.collect(Collectors.toList()));

			result.getArtikels().forEach(a -> a.setLevArts(new ArrayList<>()));
		}

		return result;
	}

	public static ArtikelRest artikelToArtikelRest(Artikel artikel) {
		ArtikelRest result = new ArtikelRest();

		result.setId(artikel.getId());

		result.setOmschrijving(artikel.getOmschrijving());

		if (!CollectionUtils.isEmpty(artikel.getLevArts())) {
			result.setLeveranciers(artikel.getLevArts().stream()
				.filter(la -> la.getLeverancier() != null)
				.map(LevArt::getLeverancier)
				.collect(Collectors.toList()));

			result.getLeveranciers().forEach(la -> la.setLevArts(new ArrayList<>()));
		}

		return result;
	}

}
