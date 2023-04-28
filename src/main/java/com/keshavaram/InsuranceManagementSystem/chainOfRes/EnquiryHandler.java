package com.keshavaram.InsuranceManagementSystem.chainOfRes;

public interface EnquiryHandler {
	boolean handle();
	void setNext(EnquiryHandler handler);
}
