/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Glenn Lefevere
 *
 */
@Embeddable
public class AuditData implements Cloneable, Serializable {

	/** The Constant AUDIT_CREATED_BY. */
	public static final String AUDIT_CREATED_BY = "USER_CREA";

	/** The Constant AUDIT_CREATED_DATE. */
	public static final String AUDIT_CREATED_DATE = "DT_CREA";

	/** The Constant AUDIT_MODIFIED_BY. */
	public static final String AUDIT_MODIFIED_BY = "USER_MOD";

	/** The Constant AUDIT_MODIFIED_DATE. */
	public static final String AUDIT_MODIFIED_DATE = "DT_MOD";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8737064292239397404L;

	/** The user id of the person that created the entity. */
	@Column(name = AUDIT_CREATED_BY, length = 50)
	protected String creationUser;

	/** The creation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = AUDIT_CREATED_DATE)
	protected Date creationDate;

	/** The user id of the person that last changed the entity. */
	@Column(name = AUDIT_MODIFIED_BY, length = 50)
	protected String modificationUser;

	/** The change date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = AUDIT_MODIFIED_DATE)
	protected Date modificationDate;

	/**
	 * Default Constructor
	 */
	public AuditData() {
	}

	/**
	 * Copy Constructor
	 * 
	 * @param audit
	 *            the audit data
	 */
	public AuditData(AuditData audit) {
		setCreationDate(audit.getCreationDate());
		setCreationUser(audit.getCreationUser());
		setModificationDate(audit.getModificationDate());
		setModificationDate(audit.getModificationDate());
	}

	/**
	 * Gets the user id of the person that created the entity.
	 * 
	 * @return the user id of the person that created the entity
	 */
	@Column(name = AUDIT_CREATED_BY, length = 50)
	public String getCreationUser() {
		return this.creationUser;
	}

	/**
	 * Sets the user id of the person that created the user.
	 * 
	 * @param userAanmaak
	 *            the new user id of the person that created the user
	 */
	public void setCreationUser(final String userAanmaak) {
		this.creationUser = userAanmaak;
	}

	/**
	 * Gets the creation date.
	 * 
	 * @return the creation date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = AUDIT_CREATED_DATE)
	public Date getCreationDate() {
		return this.creationDate;
	}

	/** {@inheritDoc} */
	public void setCreationDate(Date dtAanmaak) {
		this.creationDate = dtAanmaak;
	}

	/** {@inheritDoc} */
	@Column(name = AUDIT_MODIFIED_BY, length = 50)
	public String getModificationUser() {
		return this.modificationUser;
	}

	/** {@inheritDoc} */
	public void setModificationUser(String userWijzig) {
		this.modificationUser = userWijzig;
	}

	/** {@inheritDoc} */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = AUDIT_MODIFIED_DATE)
	public Date getModificationDate() {
		return this.modificationDate;
	}

	/** {@inheritDoc} */
	public void setModificationDate(final Date dtWijzig) {
		this.modificationDate = dtWijzig;
	}

	/**
	 * Sets the default AuditData for a creation into the given Auditable entity.
	 * 
	 * @param entity
	 *            the AuditableEntity
	 */
	public static void setDefaultCreateAuditData(final Auditable entity) {
		final AuditData auditData = getDefaultCreateAuditData();
		entity.setAuditData(auditData);
	}

	/**
	 * Gets the default create AuditData. Creation date will be the current
	 * date, the creation user is the name of the authentication in the
	 * SecurityContext.
	 * 
	 * @return the default create audit
	 */
	public static AuditData getDefaultCreateAuditData() {
		final AuditData auditData = new AuditData();
		setDefaultCreateValues(auditData);
		return auditData;
	}

	/**
	 * Sets the default create values.
	 * 
	 * @param auditData
	 *            the new defulat create values
	 */
	public static void setDefaultCreateValues(final AuditData auditData) {
		String userid = SecurityUtils.getUserId();
		if (userid == null) {
			userid = SecurityUtils.DEFAULT_USERID;
		}
		auditData.setCreationUser(userid);
		auditData.setCreationDate(new Date());
	}

	/**
	 * If there is no AuditData present, a new AuditData will be created with
	 * the default create values. The update values will be set to the current
	 * date and the name of the authentication in the security context.
	 * 
	 * @param entity
	 *            the AuditableEntity
	 */
	public static void setDefaultUpdateAuditData(final Auditable entity) {
		AuditData auditData = entity.getAuditData();
		if (auditData == null) {
			auditData = getDefaultCreateAuditData();
			entity.setAuditData(auditData);
		}
		setDefaultUpdateAuditData(auditData);
	}

	/**
	 * Sets the default update AuditData.
	 * 
	 * @param auditData
	 *            the new default update values
	 */
	public static void setDefaultUpdateAuditData(final AuditData auditData) {
		String userid = SecurityUtils.getUserId();
		if (userid == null) {
			userid = SecurityUtils.DEFAULT_USERID;
		}
		auditData.setModificationDate(new Date());
		auditData.setModificationUser(userid);
	}

	/**
	 * Contains AuditData.
	 * 
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 */
	public static boolean containsAuditData(final Auditable entity) {
		return entity.getAuditData() != null;
	}
}
