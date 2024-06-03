package com.yaksha.training.insurancepolicy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;

@Service
public class InsurancePolicyService {

	public Page<InsurancePolicy> getInsurancePolicies(Pageable pageable) {
		// write your logic here
		return null;
	}

	public InsurancePolicy saveInsurancePolicy(InsurancePolicy insurancePolicy) {
		// write your logic here
		return null;
	}

	public InsurancePolicy getInsurancePolicy(Long id) {
		// write your logic here
		return null;
	}

	public boolean deleteInsurancePolicy(Long id) {
		// write your logic here
		return false;
	}

	public Page<InsurancePolicy> searchInsurancePolicies(String theSearchName, Pageable pageable) {
		// write your logic here
		return null;
	}

	public boolean updateInsurancePolicyClaimed(Long id) {
		// write your logic here
		return false;
	}
}
