/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Artikel extends EntityObject {

	private String omschrijving;

	// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	// @JoinTable(name = "LEVART", joinColumns = { @JoinColumn(name = "IDART", nullable = false, updatable = false) },
	// inverseJoinColumns = { @JoinColumn(name = "IDLEV", nullable = false, updatable = true) })
	// private List<Leverancier> leveranciers = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel")
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

	public void addLeverancier(Leverancier leverancier) {
		LevArt la = new LevArt();
		la.setArtikel(this);
		la.setLeverancier(leverancier);
		this.levArts.add(la);
	}

	// /**
	// * @return the leveranciers
	// */
	// public List<Leverancier> getLeveranciers() {
	// return leveranciers;
	// }
	//
	// /**
	// * @param leveranciers
	// * the leveranciers to set
	// */
	// public void setLeveranciers(List<Leverancier> leveranciers) {
	// this.leveranciers = leveranciers;
	// }
	//
	// public void addLeverancier(Leverancier leverancier) {
	// leveranciers.add(leverancier);
	// if (CollectionUtils.isEmpty(leverancier.getArtikels()) || !leverancier.getArtikels().contains(this)) {
	// leverancier.addArtikel(this);
	// }
	// }

}
