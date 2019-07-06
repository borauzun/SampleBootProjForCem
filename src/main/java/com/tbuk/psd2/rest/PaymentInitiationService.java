package com.tbuk.psd2.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbuk.psd2.model.payment.PaymentCancelationRequest;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.payment.DomesticPaymentInitiationRequest;
import com.tbuk.psd2.service.AisService;
import com.tbuk.psd2.service.PaymentService;

@RestController
@RequestMapping(value="/PaymentInitiation")
public class PaymentInitiationService {
 
	@Autowired
	PaymentService service;
 
	@RequestMapping(value="/temp",method=RequestMethod.GET)
	public ResponseEntity<String> temp()  {
		return new ResponseEntity<String>(service.getTemp(),HttpStatus.OK);
	}
	
	// DOMESTIC PAYMENTS
	@RequestMapping(value="/domestic/instantPayment",method=RequestMethod.POST)
	public ResponseEntity<String> orderUKInstantPayment(@RequestHeader("Authorization") String jwtToken, // HTTP headers
			                                            DomesticPaymentInitiationRequest payementRequest)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	@RequestMapping(value="/domestic/futurePayment",method=RequestMethod.POST)
	public ResponseEntity<String> orderUKFuturePayment(@RequestHeader("Authorization") String jwtToken, // HTTP headers
														DomesticPaymentInitiationRequest payementRequest)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	//(DOMESTIC) STANDING ORDERS
	
	@RequestMapping(value="/domestic/standingOrder",method=RequestMethod.POST)
	public ResponseEntity<String> orderUKSOPayment(@RequestHeader("Authorization") String jwtToken, // HTTP headers
			                                       DomesticPaymentInitiationRequest payementRequest)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
	@RequestMapping(value="/domestic/standingOrder",method=RequestMethod.GET)
	public ResponseEntity<String> listUKSOPayments(@RequestHeader("Authorization") String jwtToken, // HTTP headers
			PaymentCancelationRequest payementRequest)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	@RequestMapping(value="/domestic/standingOrder",method=RequestMethod.DELETE)
	public ResponseEntity<String> orderUKSOPaymentCancel(@RequestHeader("Authorization") String jwtToken, // HTTP headers
			PaymentCancelationRequest payementRequest)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
	// INTERNATIONAL PAYMENTS
	@RequestMapping(value="/international/swift",method=RequestMethod.POST)
	public ResponseEntity<String> orderPayment(@RequestHeader("Authorization") String jwtToken, // HTTP headers
			                                   DomesticPaymentInitiationRequest payementRequest)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	@RequestMapping(value="/international/TR",method=RequestMethod.POST)
	public ResponseEntity<String> directDebit(@RequestHeader("Authorization") String jwtToken, // HTTP headers
			                                  DomesticPaymentInitiationRequest payementRequest)  {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
	

}

