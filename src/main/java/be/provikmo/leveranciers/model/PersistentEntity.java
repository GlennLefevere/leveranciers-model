/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import javax.persistence.MappedSuperclass;

/**
 * @author Glenn Lefevere
 *
 */
@MappedSuperclass
public abstract class PersistentEntity implements Persistent {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for construction of the Entity
	 */
	public PersistentEntity() {
	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Persistent other = (Persistent) obj;

		if (this.getId() != null && other.getId() != null) {
			return this.getId().equals(other.getId());
		} else {
			return super.equals(other);
		}
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (getId() == null || getId().equals("")) {
			return super.hashCode();
		}
		return getId().hashCode();

	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getClass().toString() + " with pk " + getId();
	}
}
