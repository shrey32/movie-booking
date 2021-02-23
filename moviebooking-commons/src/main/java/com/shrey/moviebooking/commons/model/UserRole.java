package com.shrey.moviebooking.commons.model;

import com.shrey.moviebooking.commons.enums.UserRoleEnum;

/**
 * 
 * @author Shrey
 *
 */
public class UserRole extends DBEntity{

	private long id;
	private UserRoleEnum role = UserRoleEnum.GUEST;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserRoleEnum getRole() {
		return role;
	}

	public void setRole(UserRoleEnum role) {
		this.role = role;
	}

}
