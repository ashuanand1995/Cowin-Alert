package com.aashutoshanand.CowinAlert.helper;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class Helper {

	private static final Logger logger = LoggerFactory.getLogger(Helper.class);

	public Date returnDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Time resultDate = null;
		try {
			resultDate = new java.sql.Time(format.parse(date).getTime());
		} catch (Exception e) {
			logger.error("date not in correct format-"+e.getMessage()+".Please provide date in dd-MM-yyyy format.");
			return null;
		}
		return resultDate;
	}

	public HttpEntity<String> getRequestEntity(){
		return new HttpEntity<String>(getHeaders());
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-type", "application/json");
		return httpHeaders;
	}
}
