/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
@Table(name = "ARTIKELS")
public class Artikel extends AuditableEntity {
	private static final long serialVersionUID = 1L;

	private String omschrijving;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "LEVART", joinColumns = { @JoinColumn(name = "IDART", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "IDLEV", nullable = false, updatable = true) })
	@OrderBy("naam ASC")
	private List<Leverancier> leveranciers = new ArrayList<>();

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

	public void addLeverancier(Leverancier leverancier) {
		this.leveranciers.add(leverancier);
		leverancier.getArtikels().add(this);
	}

}
