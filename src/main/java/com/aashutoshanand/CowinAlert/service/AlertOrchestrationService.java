package com.aashutoshanand.CowinAlert.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashutoshanand.CowinAlert.helper.Helper;
import com.aashutoshanand.CowinAlert.helper.RestClient;
import com.aashutoshanand.CowinAlert.model.AppointmentAvailabilityByPinResponse;
import com.aashutoshanand.CowinAlert.model.Session;
import com.aashutoshanand.CowinAlert.model.VaccineDetail;
import com.aashutoshanand.CowinAlert.model.VaccineDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AlertOrchestrationService {

	@Autowired
	private RestClient restClient;

	@Autowired
	private Helper helper;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
	private EmailTriggerService emailTriggerService;
	

	LocalDate localDate = LocalDate.now();

	public void checkSlots(String pincode, String dateStr) {
		try {
		Date date = helper.returnDate(dateStr);
		
		if (date != null) {
			AppointmentAvailabilityByPinResponse response = restClient.getSlotAvailabilityInformation(pincode, dateStr);
			if(response.getSessions().size()>0) {
				VaccineDetails vaccineDetails = new VaccineDetails();
				List<VaccineDetail> vaccineDetailsList = new ArrayList<>();
				for(Session session:response.getSessions()) {
					VaccineDetail vaccineDetail = new VaccineDetail();
					vaccineDetail.setAddress(session.getAddress());
					vaccineDetail.setAvailableCapacityDose1(session.getAvailableCapacityDose1());
					vaccineDetail.setAvailableCapacityDose2(session.getAvailableCapacityDose2());
					vaccineDetail.setCentreName(session.getName());
					vaccineDetail.setDate(session.getDate());
					vaccineDetail.setDistrictName(session.getDistrictName());
					vaccineDetail.setFeeType(session.getFeeType());
					vaccineDetail.setPincode(session.getPincode());
					vaccineDetail.setTimePeriod(session.getFrom()+" - "+session.getTo());
					vaccineDetail.setVaccineName(session.getVaccine());
					vaccineDetailsList.add(vaccineDetail);
				}
				vaccineDetails.setSessions(vaccineDetailsList);
				
				String vaccineDetailsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(vaccineDetails);
				emailTriggerService.triggerEmail(vaccineDetailsJson);
			}
		}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
