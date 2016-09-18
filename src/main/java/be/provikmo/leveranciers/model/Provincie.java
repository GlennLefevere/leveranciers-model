/**
 * (c) 2014 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Provincie.
 *
 * @author infglef
 */
@Entity
@Table(name = "PROVINCIES")
public class Provincie extends AuditableEntity {
	private static final long serialVersionUID = 1L;

	private String naam;
	private int taal;

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
	 * @return the taal
	 */
	public int getTaal() {
		return taal;
	}

	/**
	 * @param taal
	 *            the taal to set
	 */
	public void setTaal(int taal) {
		this.taal = taal;
	}

}
