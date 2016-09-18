/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Target;

/**
 * @author Glenn Lefevere
 *
 */
@MappedSuperclass
@EntityListeners(value = AuditListener.class)
public class AuditableEntity extends PersistentEntity implements Auditable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	protected String id;

	@Embedded
	@Target(AuditData.class)
	private AuditData audit;

	/**
	 * The default constructor
	 */
	public AuditableEntity() {
		super();
		audit = new AuditData();
	}

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public void setId(Serializable id) {
		this.id = (String) id;
	}

	/**
	 * @return the audit
	 */
	public AuditData getAuditData() {
		return audit;
	}

	/**
	 * @param audit
	 *            the audit to set
	 */
	public void setAuditData(AuditData audit) {
		this.audit = audit;
	}

}
