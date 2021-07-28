package com.aashutoshanand.CowinAlert.helper;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.aashutoshanand.CowinAlert.model.AppointmentAvailabilityByPinResponse;

@Component
public class RestClient {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Helper helper;

	@Value("${cowinURLForPincode}")
	private String cowinURLForPincode;

	private static final Logger logger = LoggerFactory.getLogger(RestClient.class);
	
	@Scheduled(cron="${cron.sequence.for.email}")
	public AppointmentAvailabilityByPinResponse getSlotAvailabilityInformation(String pinCode, String dateStr) {
		try {
			URI cowinSlotsByPincodeURL = UriComponentsBuilder.fromUriString(cowinURLForPincode)
					.queryParam("pincode", pinCode).queryParam("date", dateStr).build().toUri();

			ResponseEntity<AppointmentAvailabilityByPinResponse> response = restTemplate.exchange(
					cowinSlotsByPincodeURL, HttpMethod.GET, helper.getRequestEntity(),
					AppointmentAvailabilityByPinResponse.class);
			logger.info("HTTP Status code : " + response.getStatusCodeValue());

			if (response.getStatusCodeValue() == 200) {
				return response.getBody();
			}
		} catch (Exception e) {
			logger.error("Error while calling Slot Availability API.More info-" + e.getMessage());
		}
		return null;
	}

}
