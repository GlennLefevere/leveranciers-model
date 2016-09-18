/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Glenn Lefevere
 *
 */
@Entity
@Table(name = "MD_I18N")
public class Translation extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "locale_id", length = 5, nullable = false)
	private String locale;

	@Column(name = "sleutel", length = 240, nullable = false)
	private String waarde;

	@Column(name = "tekst", length = 4000, nullable = false)
	private String tekst;

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the waarde
	 */
	public String getWaarde() {
		return waarde;
	}

	/**
	 * @param waarde
	 *            the waarde to set
	 */
	public void setWaarde(String waarde) {
		this.waarde = waarde;
	}

	/**
	 * @return the tekst
	 */
	public String getTekst() {
		return tekst;
	}

	/**
	 * @param tekst
	 *            the tekst to set
	 */
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

}
