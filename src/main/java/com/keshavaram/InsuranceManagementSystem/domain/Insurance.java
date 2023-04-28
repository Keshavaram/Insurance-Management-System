package com.keshavaram.InsuranceManagementSystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Insurance {

	@Id
	private int policyId;
	private String policyType;
	private int premium;
	private String policyHolderName;

	public Insurance() {}

	public Insurance(int policyId, String policyType, int premium, String policyHolderName) {
		this.policyId = policyId;
		this.policyType = policyType;
		this.premium = premium;
		this.policyHolderName = policyHolderName;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public int getPolicyId() {
		return policyId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
}
