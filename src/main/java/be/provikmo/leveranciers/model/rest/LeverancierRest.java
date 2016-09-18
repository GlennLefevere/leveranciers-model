/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model.rest;

import java.util.ArrayList;
import java.util.List;

import be.provikmo.leveranciers.model.Artikel;

/**
 * @author Glenn Lefevere
 *
 */
public class LeverancierRest {
	private Long id;

	private String naam;
	private String telefoon;
	private String fax;
	private String email;
	private String website;
	private Double latitude = new Double(0);
	private Double longitude = new Double(0);
	private Boolean webshop;

	private List<Artikel> artikels = new ArrayList<>();

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
	 * @return the naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam
	 *            the naam to set
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * @return the telefoon
	 */
	public String getTelefoon() {
		return telefoon;
	}

	/**
	 * @param telefoon
	 *            the telefoon to set
	 */
	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the webshop
	 */
	public Boolean getWebshop() {
		return webshop;
	}

	/**
	 * @param webshop
	 *            the webshop to set
	 */
	public void setWebshop(Boolean webshop) {
		this.webshop = webshop;
	}

	/**
	 * @return the artikels
	 */
	public List<Artikel> getArtikels() {
		return artikels;
	}

	/**
	 * @param artikels
	 *            the artikels to set
	 */
	public void setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
	}

}
