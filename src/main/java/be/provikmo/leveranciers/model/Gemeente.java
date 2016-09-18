/**
 * (c) 2014 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Gemeente.
 *
 * @author infglef
 */
@Entity
@Table(name = "POSTCODES")
public class Gemeente extends AuditableEntity {
	private static final long serialVersionUID = 1L;

	private Long postcode;
	private String gemeente;

	/**
	 * @return the postcode
	 */
	public Long getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(Long postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the gemeente
	 */
	public String getGemeente() {
		return gemeente;
	}

	/**
	 * @param gemeente
	 *            the gemeente to set
	 */
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	/**
	 * 
	 * @return een string
	 */
	public String getGemeenteEnPostcode() {
		return postcode + " " + gemeente;
	}

}
