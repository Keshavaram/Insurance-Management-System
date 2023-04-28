package com.keshavaram.InsuranceManagementSystem.facade;

public class GetApproval implements ApprovePolicy {
	private int premium;
	private String username;
	FinancialApprovalFacade ff;
	SocialApprovalFacade sf;
	public GetApproval(int premium, String username) {
		this.premium = premium;
		this.username = username;
		ff = new FinancialApproval(premium);
		sf = new SocialApproval(username);
	}
	@Override
	public boolean approve() {
		return ff.getFinancialApproval() && sf.getSocialApproval();
	}
}
