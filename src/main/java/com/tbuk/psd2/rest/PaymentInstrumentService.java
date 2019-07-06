package com.tbuk.psd2.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbuk.psd2.service.AisService;

@RestController
@RequestMapping(value="/PaymentInstrument")
public class PaymentInstrumentService {
 
	@Autowired
	AisService as;
 
	@RequestMapping(value="/getBalance",method=RequestMethod.GET)
	public ResponseEntity<String> getBalance()  {
		     Object retVal= as.getAccountDetail("1");
		     return new ResponseEntity<String>((String)retVal,HttpStatus.OK);
	}
	
	

}

