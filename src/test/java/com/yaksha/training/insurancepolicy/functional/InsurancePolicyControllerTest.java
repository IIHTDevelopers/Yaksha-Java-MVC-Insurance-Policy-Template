package com.yaksha.training.insurancepolicy.functional;

import static com.yaksha.training.insurancepolicy.utils.MasterData.asJsonString;
import static com.yaksha.training.insurancepolicy.utils.MasterData.getInsurancePolicy;
import static com.yaksha.training.insurancepolicy.utils.MasterData.getInsurancePolicyList;
import static com.yaksha.training.insurancepolicy.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.businessTestFile;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.currentTest;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.testReport;
import static com.yaksha.training.insurancepolicy.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yaksha.training.insurancepolicy.controller.InsurancePolicyController;
import com.yaksha.training.insurancepolicy.entity.InsurancePolicy;
import com.yaksha.training.insurancepolicy.service.InsurancePolicyService;

public class InsurancePolicyControllerTest {

	@Mock
	private InsurancePolicyService insurancePolicyService;

	@InjectMocks
	private InsurancePolicyController insurancePolicyController;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(insurancePolicyController).build();
	}

	@After
	public void afterAll() {
		testReport();
	}

	@Test
	public void testControllerListInsurancePolicysHome() throws Exception {
		try {

			List<InsurancePolicy> expected = getInsurancePolicyList(5);
			when(insurancePolicyService.getInsurancePolicys()).thenReturn(expected);
			MvcResult result = this.mockMvc.perform(get("/")).andReturn();
			yakshaAssert(currentTest(),
					result.getModelAndView() != null && result.getModelAndView().getViewName() != null
							&& result.getModelAndView().getViewName().contentEquals("list-insurancePolicies")
							&& asJsonString(expected)
									.equals(asJsonString(result.getModelAndView().getModel().get("insurancePolicys")))
											? "true"
											: "false",
					businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	@Test
	public void testControllerListInsurancePolicys() throws Exception {
		List<InsurancePolicy> expected = getInsurancePolicyList(5);
		when(insurancePolicyService.getInsurancePolicys()).thenReturn(expected);
		MvcResult result = this.mockMvc.perform(get("/list")).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("list-insurancePolicies")
						&& asJsonString(expected)
								.equals(asJsonString(result.getModelAndView().getModel().get("insurancePolicys")))
										? "true"
										: "false",
				businessTestFile);
	}

	@Test
	public void testControllerShowFormForAdd() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/addInsurancePolicyForm")).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form"),
				businessTestFile);
	}

	@Test
	public void testControllerSaveInsurancePolicy() throws Exception {
		InsurancePolicy insurancePolicy = getInsurancePolicy();
		MvcResult result = this.mockMvc
				.perform(post("/saveInsurancePolicy").flashAttr("insurancePolicy", insurancePolicy)).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("redirect:/insurancePolicy/list"),
				businessTestFile);
	}

	@Test
	public void testControllerSaveInsurancePolicyHasError() throws Exception {
		InsurancePolicy insurancePolicy = getInsurancePolicy();
		insurancePolicy.setId(null);
		insurancePolicy.setFirstName(null);
		MvcResult result = this.mockMvc
				.perform(post("/saveInsurancePolicy").flashAttr("insurancePolicy", insurancePolicy)).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("add-insurancePolicy-form"),
				businessTestFile);
	}

	@Test
	public void testControllerUpdateInsurancePolicyHasError() throws Exception {
		InsurancePolicy insurancePolicy = getInsurancePolicy();
		insurancePolicy.setLastName(null);
		MvcResult result = this.mockMvc
				.perform(post("/saveInsurancePolicy").flashAttr("insurancePolicy", insurancePolicy)).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form"),
				businessTestFile);
	}

	@Test
	public void testControllerShowFormForUpdate() throws Exception {
		InsurancePolicy insurancePolicy = getInsurancePolicy();
		when(insurancePolicyService.getInsurancePolicy(insurancePolicy.getId())).thenReturn(insurancePolicy);
		MvcResult result = this.mockMvc.perform(
				get("/updateInsurancePolicyForm").param("insurancePolicyId", insurancePolicy.getId().toString()))
				.andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("update-insurancePolicy-form"),
				businessTestFile);
	}

	@Test
	public void testControllerDeleteInsurancePolicy() throws Exception {
		InsurancePolicy insurancePolicy = getInsurancePolicy();
		MvcResult result = this.mockMvc
				.perform(get("/delete").param("insurancePolicyId", insurancePolicy.getId().toString())).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("redirect:/insurancePolicy/list"),
				businessTestFile);
	}

	@Test
	public void testControllerSearchInsurancePolicys() throws Exception {
		String key = randomStringWithSize(2);
		List<InsurancePolicy> expected = getInsurancePolicyList(5);
		when(insurancePolicyService.searchInsurancePolicys(key)).thenReturn(expected);
		MvcResult result = this.mockMvc.perform(post("/search").param("theSearchName", key)).andReturn();
		yakshaAssert(currentTest(),
				result.getModelAndView() != null && result.getModelAndView().getViewName() != null
						&& result.getModelAndView().getViewName().contentEquals("list-insurancePolicies")
						&& asJsonString(expected)
								.equals(asJsonString(result.getModelAndView().getModel().get("insurancePolicys")))
										? "true"
										: "false",
				businessTestFile);
	}

}
