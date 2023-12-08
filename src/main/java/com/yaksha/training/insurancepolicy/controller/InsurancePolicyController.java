package com.yaksha.training.insurancepolicy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;

@Controller
@RequestMapping(value = { "/insurancePolicy", "/" })
public class InsurancePolicyController {

	@GetMapping(value = { "/list", "/" })
	public String listInsurancePolicys(Model model) {
		return "";
	}

	@GetMapping("/addInsurancePolicyForm")
	public String showFormForAdd(Model model) {
		return "";
	}

	@PostMapping("/saveInsurancePolicy")
	public String saveInsurancePolicy(@Valid @ModelAttribute("insurancePolicy") InsurancePolicy insurancePolicy,
			BindingResult bindingResult) {
		return "";
	}

	@GetMapping("/updateInsurancePolicyForm")
	public String showFormForUpdate(@RequestParam("insurancePolicyId") Long id, Model model) {
		return "";
	}

	@GetMapping("/delete")
	public String deleteInsurancePolicy(@RequestParam("insurancePolicyId") Long id) {
		return "";
	}

	@PostMapping("/search")
	public String searchInsurancePolicys(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		return "";
	}
}
