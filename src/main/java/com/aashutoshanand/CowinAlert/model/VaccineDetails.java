package com.aashutoshanand.CowinAlert.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"VaccineDetails"
})

public class VaccineDetails {

	@JsonProperty("VaccineDetails")
	private List<VaccineDetail> vaccineDetail = null;
	
	@JsonProperty("VaccineDetails")
	public List<VaccineDetail> getSessions() {
	return vaccineDetail;
	}

	@JsonProperty("VaccineDetails")
	public void setSessions(List<VaccineDetail> vaccineDetail) {
	this.vaccineDetail = vaccineDetail;
	}
	
}
