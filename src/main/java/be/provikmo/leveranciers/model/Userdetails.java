/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Glenn Lefevere
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"identitystatus",
	"userid",
	"firstname",
	"lastname",
	"langpref",
	"email",
	"rrn",
	"enterprisenr",
	"corrnr",
	"mainmandatary"
})
@XmlRootElement(name = "userdetails")
public class Userdetails implements Serializable {

	private final static long serialVersionUID = 1L;
	@XmlElement(required = true)
	protected String identitystatus;
	@XmlElement(required = true)
	protected String userid;
	@XmlElement(required = true)
	protected String firstname;
	@XmlElement(required = true)
	protected String lastname;
	@XmlElement(required = true)
	protected String langpref;
	@XmlElement(required = true)
	protected String email;
	@XmlElement(required = true)
	protected String rrn;
	@XmlElement(required = true)
	protected String enterprisenr;
	@XmlElement(required = true)
	protected String corrnr;
	protected boolean mainmandatary;

	/**
	 * Gets the value of the identitystatus property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getIdentitystatus() {
		return identitystatus;
	}

	/**
	 * Sets the value of the identitystatus property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setIdentitystatus(String value) {
		this.identitystatus = value;
	}

	/**
	 * Gets the value of the userid property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * Sets the value of the userid property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setUserid(String value) {
		this.userid = value;
	}

	/**
	 * Gets the value of the firstname property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the value of the firstname property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setFirstname(String value) {
		this.firstname = value;
	}

	/**
	 * Gets the value of the lastname property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the value of the lastname property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setLastname(String value) {
		this.lastname = value;
	}

	/**
	 * Gets the value of the langpref property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getLangpref() {
		return langpref;
	}

	/**
	 * Sets the value of the langpref property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setLangpref(String value) {
		this.langpref = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the rrn property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getRrn() {
		return rrn;
	}

	/**
	 * Sets the value of the rrn property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setRrn(String value) {
		this.rrn = value;
	}

	/**
	 * Gets the value of the enterprisenr property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getEnterprisenr() {
		return enterprisenr;
	}

	/**
	 * Sets the value of the enterprisenr property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setEnterprisenr(String value) {
		this.enterprisenr = value;
	}

	/**
	 * Gets the value of the corrnr property.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getCorrnr() {
		return corrnr;
	}

	/**
	 * Sets the value of the corrnr property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setCorrnr(String value) {
		this.corrnr = value;
	}

	/**
	 * Gets the value of the mainmandatary property.
	 * 
	 */
	public boolean isMainmandatary() {
		return mainmandatary;
	}

	/**
	 * Sets the value of the mainmandatary property.
	 * 
	 */
	public void setMainmandatary(boolean value) {
		this.mainmandatary = value;
	}
}
