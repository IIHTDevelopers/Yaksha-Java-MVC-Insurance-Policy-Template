package com.yaksha.training.insurancepolicy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

	List<InsurancePolicy> findByFirstNameAndLastName(@Param("keyword") String keyword);
}
