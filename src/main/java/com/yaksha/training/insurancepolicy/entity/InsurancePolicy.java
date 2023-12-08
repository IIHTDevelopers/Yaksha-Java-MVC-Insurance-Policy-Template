package com.yaksha.training.insurancepolicy.entity;

public class InsurancePolicy {

	private Long id;

	private String firstName;

	private String lastName;

	private Double amount;

	private Long interest;

	private Long tenure;

	private String startDate;

	private String nominee;

	private String policyName;

	public InsurancePolicy() {

	}

	public InsurancePolicy(Long id, String firstName, String lastName, Double amount, Long interest, Long tenure,
			String startDate, String nominee) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.amount = amount;
		this.interest = interest;
		this.tenure = tenure;
		this.startDate = startDate;
		this.nominee = nominee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getInterest() {
		return interest;
	}

	public void setInterest(Long interest) {
		this.interest = interest;
	}

	public Long getTenure() {
		return tenure;
	}

	public void setTenure(Long tenure) {
		this.tenure = tenure;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	@Override
	public String toString() {
		return "Insurance{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", amount=" + amount + ", interest=" + interest + ", tenure='" + tenure + '\'' + ", startDate='"
				+ startDate + '\'' + ", nominee='" + nominee + '\'' + '}';
	}
}
