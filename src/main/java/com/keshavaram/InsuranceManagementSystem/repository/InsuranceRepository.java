package com.keshavaram.InsuranceManagementSystem.repository;

import com.keshavaram.InsuranceManagementSystem.domain.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
}
