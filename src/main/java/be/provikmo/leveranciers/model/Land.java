/**
 * (c) 2014 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Land.
 *
 * @author infonav
 */
@Entity
@Table(name = "LANDEN")
public class Land extends AuditableEntity implements Comparable<Land> {
	private static final long serialVersionUID = 1L;

	private String naam;

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

	/** {@inheritDoc} */
	@Override
	public int compareTo(Land o) {
		return this.naam.compareTo(o.naam);
	}

}
