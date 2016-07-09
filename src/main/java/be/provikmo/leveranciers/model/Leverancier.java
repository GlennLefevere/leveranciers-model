/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Leverancier extends EntityObject {

	private String naam;
	private String straat;
	private String telefoon;
	private String fax;
	private String email;
	private String website;
	private Double latitude = new Double(0);
	private Double longitude = new Double(0);
	private Boolean webshop;

	@ManyToOne
	@JoinColumn(name = "IDLAND")
	@Cascade(CascadeType.ALL)
	@JsonInclude
	private Land land;

	@ManyToOne
	@JoinColumn(name = "IDPOSTCODE")
	@Cascade(CascadeType.ALL)
	@JsonInclude
	private Gemeente gemeente;

	@ManyToOne
	@JoinColumn(name = "IDPROVINCIE")
	@Cascade(CascadeType.ALL)
	@JsonInclude
	private Provincie provincie;

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "LEVART", joinColumns = { @JoinColumn(name = "IDLEV", nullable = false, updatable = false) },
	// inverseJoinColumns = { @JoinColumn(name = "IDART", nullable = false, updatable = true) })
	// @Cascade(CascadeType.REFRESH)
	// private List<Artikel> artikels = new ArrayList<>();

	@OneToMany(mappedBy = "leverancier",orphanRemoval= true)
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
	 * @return the straat
	 */
	public String getStraat() {
		return straat;
	}

	/**
	 * @param straat
	 *            the straat to set
	 */
	public void setStraat(String straat) {
		this.straat = straat;
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
	 * @return the land
	 */
	public Land getLand() {
		return land;
	}

	/**
	 * @param land
	 *            the land to set
	 */
	public void setLand(Land land) {
		this.land = land;
	}

	/**
	 * @return the gemeente
	 */
	public Gemeente getGemeente() {
		return gemeente;
	}

	/**
	 * @param gemeente
	 *            the gemeente to set
	 */
	public void setGemeente(Gemeente gemeente) {
		this.gemeente = gemeente;
	}

	/**
	 * @return the provincie
	 */
	public Provincie getProvincie() {
		return provincie;
	}

	/**
	 * @param provincie
	 *            the provincie to set
	 */
	public void setProvincie(Provincie provincie) {
		this.provincie = provincie;
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

	// /**
	// * @return the artikels
	// */
	// public List<Artikel> getArtikels() {
	// return artikels;
	// }
	//
	// /**
	// * @param artikels
	// * the artikels to set
	// */
	// public void setArtikels(List<Artikel> artikels) {
	// this.artikels = artikels;
	// }
	//
	// public void addArtikel(Artikel artikel) {
	// artikels.add(artikel);
	// if (CollectionUtils.isEmpty(artikel.getLeveranciers()) || !artikel.getLeveranciers().contains(this)) {
	// artikel.addLeverancier(this);
	// }
	// }

}
