package com.tbuk.psd2.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbuk.psd2.model.payment.Charge;
import com.tbuk.psd2.model.payment.PaymentCancelationRequest;
import com.tbuk.psd2.model.request.PaymentInitiationRequest;
import com.tbuk.psd2.model.response.PaymentResult;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.service.AisService;
import com.tbuk.psd2.service.PaymentService;

@RestController
@RequestMapping(value="/PaymentInitiation")
public class PaymentInitiationService {
 
	@Autowired
	PaymentService service;
 
	
	//GENERIC
	@RequestMapping(value="/chargeEnquiry",method=RequestMethod.POST)
	public ResponseEntity<Charge> chargeEnquiry(@ModelAttribute HttpHeaders headers, PaymentInitiationRequest payementRequest)  {
		Charge charge=service.chargeEnquiry();	
		return new ResponseEntity<Charge>(charge,HttpStatus.OK);
	}
	@RequestMapping(value="/rateEnquiry",method=RequestMethod.POST)
	public ResponseEntity<Double> rateEnquiry(@ModelAttribute HttpHeaders headers,PaymentInitiationRequest payementRequest)  {
		double rate=service.rateEnquiry();	
		return new ResponseEntity<Double>(rate,HttpStatus.OK);
	}
	@RequestMapping(value="/paymentStatusEnquiry",method=RequestMethod.POST)
	public ResponseEntity<PaymentResult> paymentStatusEnquiry(@ModelAttribute HttpHeaders headers,PaymentInitiationRequest payementRequest)  {
		PaymentResult result=service.paymentStatusEnquiry();
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}
	// DOMESTIC PAYMENTS
	@RequestMapping(value="/domesticPayment",method=RequestMethod.POST)
	public ResponseEntity<PaymentResult> domesticPayment(@ModelAttribute HttpHeaders headers, PaymentInitiationRequest payementRequest)  {
		PaymentResult result=service.domesticPayment();          
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}
	@RequestMapping(value="/transferBetweenAccounts",method=RequestMethod.POST)
	public ResponseEntity<PaymentResult> transferBetweenAccounts(@ModelAttribute HttpHeaders headers,PaymentInitiationRequest payementRequest)  {
		PaymentResult result=service.transferBetweenAccounts(); 
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}
	
	
	
	// INTERNATIONAL PAYMENTS
	@RequestMapping(value="/internationalPayment",method=RequestMethod.POST)
	public ResponseEntity<PaymentResult> internationalPayment(@ModelAttribute HttpHeaders headers,PaymentInitiationRequest payementRequest)  {
		PaymentResult result=service.internationalPayment(); 
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}
	
	
	//Header'i tekrar tekrar her metoda eklememek icin
			@ModelAttribute
			public HttpHeaders getHeaders(@RequestHeader(value="client_id", required = false) String client_Id,
					                        @RequestHeader(value="client_secret", required = false) String client_secret,
					                        @RequestHeader(value="scope", required = false) String scope,
					                        @RequestHeader(value="Content-Type", required = false) String contentType,
					                        @RequestHeader(value="PSUip", required = false) String psuIp,
					                        @RequestHeader(value="Authorization", required = false) String jwtToken
					                        
					                        ) 
			{
				
			  return new HttpHeaders();
			}

}

