/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
@Table(name = "LEVERANCIERS")
public class Leverancier extends AuditableEntity {
	private static final long serialVersionUID = 1L;

	private String naam;

	@Column(name = "ADRES")
	private String straat;

	private String telefoon;

	private String fax;

	private String email;

	private long prof = 0;

	@Column(name = "WWW")
	private String website;

	private Double latitude = new Double(0);
	private Double longitude = new Double(0);

	private Boolean webshop;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "LEVART", joinColumns = { @JoinColumn(name = "IDLEV", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "IDART", nullable = false, updatable = true) })
	private List<Artikel> artikels = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "IDLAND")
	private Land land;

	@ManyToOne
	@JoinColumn(name = "IDPOSTCODE")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Gemeente gemeente;

	@ManyToOne
	@JoinColumn(name = "IDPROVINCIE")
	private Provincie provincie;

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
	 * @return the prof
	 */
	public long getProf() {
		return prof;
	}

	/**
	 * @param prof
	 *            the prof to set
	 */
	public void setProf(long prof) {
		this.prof = prof;
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

}
