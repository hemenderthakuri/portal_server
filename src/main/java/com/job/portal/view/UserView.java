package com.job.portal.view;

import com.job.portal.core.IPortalView;
import com.job.portal.model.Users;

public class UserView implements IPortalView{

	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
