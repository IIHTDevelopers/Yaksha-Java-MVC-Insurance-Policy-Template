package com.yaksha.training.insurancepolicy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

	// feel free to update this
	Page<InsurancePolicy> findAllInsurancePolicy(Pageable pageable);

	// feel free to update this
	Page<InsurancePolicy> findByFirstNameOrLastNameOrPolicyName(@Param("keyword") String keyword, Pageable pageable);

	// feel free to update this
	void updateInsurancePolicyClaimed(@Param("id") Long id);

}
