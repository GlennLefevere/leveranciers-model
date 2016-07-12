/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
public class LevArt extends EntityObject {

	@JsonBackReference("lev-levart")
	@ManyToOne
	@JoinColumn(name = "LEVERANCIER_ID")
	private Leverancier leverancier;

	@JsonBackReference("atikel-levart")
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "ARTIKEL_ID")
	private Artikel artikel;

	/**
	 * @return the leverancier
	 */
	public Leverancier getLeverancier() {
		return leverancier;
	}

	/**
	 * @param leverancier
	 *            the leverancier to set
	 */
	public void setLeverancier(Leverancier leverancier) {
		this.leverancier = leverancier;
	}

	/**
	 * @return the artikel
	 */
	public Artikel getArtikel() {
		return artikel;
	}

	/**
	 * @param artikel
	 *            the artikel to set
	 */
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

}
