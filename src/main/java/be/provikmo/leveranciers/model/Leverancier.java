/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
public class Leverancier extends EntityObject {

	private String naam;
	private String telefoon;
	private String fax;
	private String email;
	private String website;
	private Double latitude = new Double(0);
	private Double longitude = new Double(0);
	private Boolean webshop;

	@Embedded
	private Adres adres;

	@JsonManagedReference("lev-levart")
	@OneToMany(mappedBy = "leverancier", orphanRemoval = false)
	@Cascade(CascadeType.ALL)
	private List<LevArt> levArts = new ArrayList<>();

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

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
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

	public void addArtikel(Artikel artikel) {
		LevArt la = new LevArt();
		la.setArtikel(artikel);
		la.setLeverancier(this);
		this.levArts.add(la);
	}

}
