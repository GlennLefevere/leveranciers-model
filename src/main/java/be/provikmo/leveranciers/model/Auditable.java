/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

/**
 * @author Glenn Lefevere
 *
 */
public interface Auditable {
	/**
	 * Gets the audit data.
	 *
	 * @return the audit data
	 */
	AuditData getAuditData();

	/**
	 * Sets the audit data.
	 *
	 * @param audit
	 *            the audit data to set
	 */
	void setAuditData(AuditData audit);
}
