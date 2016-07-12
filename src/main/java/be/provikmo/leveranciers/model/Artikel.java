/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
public class Artikel extends EntityObject {

	private String omschrijving;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<LevArt> levArts = new ArrayList<>();

	/**
	 * @return the omschrijving
	 */
	public String getOmschrijving() {
		return omschrijving;
	}

	/**
	 * @param omschrijving
	 *            the omschrijving to set
	 */
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	/**
	 * @return the levArts
	 */
	public List<LevArt> getLevArts() {
		return levArts;
	}

	/**
	 * @param levArts
	 *            the levArts to set
	 */
	public void setLevArts(List<LevArt> levArts) {
		this.levArts = levArts;
	}

	public void addLeverancier(Leverancier leverancier) {
		LevArt la = new LevArt();
		la.setArtikel(this);
		la.setLeverancier(leverancier);
		this.levArts.add(la);
	}

}
