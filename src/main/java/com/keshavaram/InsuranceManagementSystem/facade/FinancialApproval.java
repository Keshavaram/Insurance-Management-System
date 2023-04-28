package com.keshavaram.InsuranceManagementSystem.facade;

public class FinancialApproval implements FinancialApprovalFacade {
	private int premium;
	public FinancialApproval(int premium) {
		this.premium = premium;
	}

	@Override
	public boolean getFinancialApproval() {
		return premium < 1000000;
	}
}
