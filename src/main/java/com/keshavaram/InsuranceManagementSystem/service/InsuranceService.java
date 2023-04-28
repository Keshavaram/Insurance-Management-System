package com.keshavaram.InsuranceManagementSystem.service;

import com.keshavaram.InsuranceManagementSystem.domain.Insurance;
import com.keshavaram.InsuranceManagementSystem.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
	@Autowired
	private InsuranceRepository repo;

	public List<Insurance> listAll()
	{
		return repo.findAll();
	}

	public void save(Insurance policy)
	{
		repo.save(policy);
	}

	public Insurance get(int policyId)
	{
		return repo.findById(policyId).get();
	}
	public void delete(int policyId)
	{
		repo.deleteById(policyId);
	}
}
