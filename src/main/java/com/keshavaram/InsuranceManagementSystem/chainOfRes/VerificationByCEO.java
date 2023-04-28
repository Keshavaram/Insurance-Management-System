package com.keshavaram.InsuranceManagementSystem.chainOfRes;

public class VerificationByCEO  implements EnquiryHandler {
	private EnquiryHandler nextHandler;
	private int premium;

	public VerificationByCEO(int premium) {
		this.premium = premium;
	}

	@Override
	public boolean handle() {
		if (premium < 100000) return true;
		return nextHandler.handle();
	}

	@Override
	public void setNext(EnquiryHandler handler) {
		nextHandler = handler;
	}
}
