/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Glenn Lefevere
 *
 */
public class AuditListener {
	/**
	 * Set auditing data when an entity is identified as modified by the EntityManager or before a new entity is
	 * persisted.
	 *
	 * @param entity
	 *            the entity to audit
	 */
	@PreUpdate
	@PrePersist
	public void setLastUpdate(AuditableEntity entity) {
		if (entity.getId() == null) {
			AuditData.setDefaultCreateAuditData(entity);
			AuditData.setDefaultUpdateAuditData(entity);
		} else {
			AuditData.setDefaultUpdateAuditData(entity);
		}
	}
}