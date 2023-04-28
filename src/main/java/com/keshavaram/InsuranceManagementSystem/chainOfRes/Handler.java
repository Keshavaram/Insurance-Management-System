package com.keshavaram.InsuranceManagementSystem.chainOfRes;

public class Handler {
	private int premium;
	private EnquiryHandler manager;

	public Handler(int premium) {
		this.premium = premium;
		this.manager = new VerificationByManager(premium);
		EnquiryHandler ceo = new VerificationByCEO(premium);
		EnquiryHandler chairPerson = new VerificationByChairPerson(premium);
		manager.setNext(ceo);
		ceo.setNext(chairPerson);
		chairPerson.setNext(null);
	}
	public boolean handle()
	{
		return manager.handle();
	}
}
