package com.tbuk.psd2.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tbuk.psd2.model.payment.Charge;
import com.tbuk.psd2.model.request.PaymentInitiationRequest;
import com.tbuk.psd2.model.response.payment.PaymentResult;
import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.service.PaymentService;

@RestController
@RequestMapping(value="/PaymentInitiation")
public class PaymentInitiationService {
 
	@Autowired
	PaymentService service;
 
	private void printHeaders(HttpHeaders headers){
		System.out.println("jwt:"+headers.getAuthorization());
		System.out.println("clientId"+headers.getClient_Id());
		System.out.println("psu IP:"+headers.getX_fapi_customer_ip_address());
		System.out.println("audience"+headers.getAudience());
		System.out.println("contentType:"+headers.getContent_Type());
	}
	private void printPayReq(PaymentInitiationRequest p) {
		try{
		ObjectMapper mapper = new ObjectMapper();
		String paymentRequestAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		System.out.println(paymentRequestAsString);
		}catch (Exception ex){}
	}
	//GENERIC

	@RequestMapping(value="/paymentStatusEnquiry/{transactionId}",method=RequestMethod.GET)
	public ResponseEntity<PaymentResult> paymentStatusEnquiry(@ModelAttribute HttpHeaders headers,@PathVariable("transactionId") String transactionId)  {
		printHeaders(headers);

		PaymentResult result=service.paymentStatusEnquiry(transactionId);
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}
	// DOMESTIC PAYMENTS
	@RequestMapping(value="/domesticPayment",method=RequestMethod.POST)
	public ResponseEntity<PaymentResult> domesticPayment(@ModelAttribute HttpHeaders headers, @RequestBody PaymentInitiationRequest payementRequest)  {
		printHeaders(headers);
		printPayReq(payementRequest);
		PaymentResult result=service.domesticPayment(payementRequest);
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}
	@RequestMapping(value="/transferBetweenAccounts",method=RequestMethod.POST)
	public ResponseEntity<PaymentResult> transferBetweenAccounts(@ModelAttribute HttpHeaders headers,@RequestBody PaymentInitiationRequest payementRequest)  {
		printHeaders(headers);
		printPayReq(payementRequest);
		PaymentResult result=service.transferBetweenAccounts(payementRequest);
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}

	// INTERNATIONAL PAYMENTS
	@RequestMapping(value="/internationalPayment",method=RequestMethod.POST)
	public ResponseEntity<PaymentResult> internationalPayment(@ModelAttribute HttpHeaders headers,@RequestBody PaymentInitiationRequest payementRequest)  {
		printHeaders(headers);
		printPayReq(payementRequest);

		PaymentResult result=service.internationalPayment(payementRequest);
		return new ResponseEntity<PaymentResult>(result,HttpStatus.OK);
	}


	@ModelAttribute
	public HttpHeaders getHeaders(@RequestHeader(value="Authorization", required = true) String jwt,
								  @RequestHeader(value="audience", required = true) String audiance,
								  @RequestHeader(value="client_Id", required = true) String clientId,
								  @RequestHeader(value="content_Type", required = false) String contentType,
								  @RequestHeader(value="nonce", required = false) String nonce,
								  @RequestHeader(value="x-fapi-customer-ip-address", required = false) String psuIp

	)
	{

		return HttpHeaders.builder().audience(audiance).Authorization(jwt).client_Id(clientId).content_Type(contentType)
				                     .x_fapi_customer_ip_address(psuIp).nonce(nonce).build();
	}

}

