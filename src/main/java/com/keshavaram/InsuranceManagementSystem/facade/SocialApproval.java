package com.keshavaram.InsuranceManagementSystem.facade;

import com.keshavaram.InsuranceManagementSystem.domain.User;
import com.keshavaram.InsuranceManagementSystem.service.UserService;

public class SocialApproval implements SocialApprovalFacade {
	private final String username;
	public SocialApproval(String username) {
		this.username = username;
	}

	@Override
	public boolean getSocialApproval() {
		return true;
	}
}
