package com.keshavaram.InsuranceManagementSystem.chainOfRes;

public class VerificationByManager implements EnquiryHandler {
	private EnquiryHandler nextHandler;
	private int premium;

	public VerificationByManager(int premium) {
		this.premium = premium;
	}

	@Override
	public boolean handle() {
		if (premium < 10000) return true;
		return nextHandler.handle();
	}

	@Override
	public void setNext(EnquiryHandler handler) {
		nextHandler = handler;
	}
}
