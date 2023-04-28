package com.keshavaram.InsuranceManagementSystem.repository;
import com.keshavaram.InsuranceManagementSystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
