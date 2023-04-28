package com.keshavaram.InsuranceManagementSystem.chainOfRes;

public class VerificationByChairPerson  implements EnquiryHandler {
	private EnquiryHandler nextHandler;
	private int premium;

	public VerificationByChairPerson(int premium) {
		this.premium = premium;
	}
	@Override
	public boolean handle() {
		return premium < 1000000;
	}

	@Override
	public void setNext(EnquiryHandler handler) {
		nextHandler = null;
	}
}
