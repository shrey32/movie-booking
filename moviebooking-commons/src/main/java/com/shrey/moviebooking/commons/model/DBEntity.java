package com.shrey.moviebooking.commons.model;

import java.util.Date;

/**
 * 
 * @author Shrey
 *
 */
public class DBEntity {

	protected Date created;
	protected Date updated;
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
