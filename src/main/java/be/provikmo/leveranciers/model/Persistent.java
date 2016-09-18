/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.leveranciers.model;

import java.io.Serializable;

/**
 * @author Glenn Lefevere
 *
 */
public interface Persistent extends Serializable {

	/**
	 * Gets the primary key.
	 *
	 * @return the PrimaryKey object for this Entity
	 */
	Serializable getId();

	/**
	 * Sets the Primary Key for this entity.
	 *
	 * @param pk
	 *            The Primary Key to be set
	 */
	void setId(Serializable pk);
}
