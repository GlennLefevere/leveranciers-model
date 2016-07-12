/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model.rest;

import java.util.ArrayList;
import java.util.List;

import be.provikmo.leveranciers.model.Leverancier;

/**
 * @author Glenn Lefevere
 *
 */
public class ArtikelRest {

	private Long id;

	private String omschrijving;

	private List<Leverancier> leveranciers = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the leveranciers
	 */
	public List<Leverancier> getLeveranciers() {
		return leveranciers;
	}

	/**
	 * @param leveranciers
	 *            the leveranciers to set
	 */
	public void setLeveranciers(List<Leverancier> leveranciers) {
		this.leveranciers = leveranciers;
	}

}
