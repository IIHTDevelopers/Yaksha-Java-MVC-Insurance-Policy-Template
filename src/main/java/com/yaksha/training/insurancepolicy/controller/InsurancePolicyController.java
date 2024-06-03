package com.yaksha.training.insurancepolicy.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = { "/insurancePolicy", "/" })
public class InsurancePolicyController {

	@GetMapping(value = { "/list", "/" })
	public String listInsurancePolicies(@PageableDefault(size = 5) Pageable pageable, Model model) {
		// write your logic here
		return "";
	}

	@GetMapping("/addInsurancePolicyForm")
	public String showFormForAdd(Model model) {
		// write your logic here
		return "";
	}

	@PostMapping("/saveInsurancePolicy")
	public String saveInsurancePolicy(@Valid @ModelAttribute("insurancePolicy") InsurancePolicy insurancePolicy,
			BindingResult bindingResult) {
		// write your logic here
		return "";
	}

	@GetMapping("/updateInsurancePolicyForm")
	public String showFormForUpdate(@RequestParam("insurancePolicyId") Long id, Model model) {
		// write your logic here
		return "";
	}

	@GetMapping("/delete")
	public String deleteInsurancePolicy(@RequestParam("insurancePolicyId") Long id) {
		// write your logic here
		return "";
	}

	@RequestMapping("/search")
	public String searchInsurancePolicys(@RequestParam(value = "theSearchName", required = false) String theSearchName,
			@PageableDefault(size = 5) Pageable pageable, Model theModel) {
		// write your logic here
		return "";
	}

	@GetMapping("/updateClaimed")
	public String updateAvailability(@RequestParam("policyId") Long id) {
		// write your logic here
		return "";
	}

}
