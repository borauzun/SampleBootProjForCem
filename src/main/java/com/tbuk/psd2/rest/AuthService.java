package com.tbuk.psd2.rest;


import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.model.response.ais.AccountDetail;
import com.tbuk.psd2.model.response.ais.AccountTransaction;
import com.tbuk.psd2.model.response.ais.Statement;
import com.tbuk.psd2.model.response.auth.BankAuthorization;
import com.tbuk.psd2.model.response.auth.PaymentUID;
import com.tbuk.psd2.service.AisService;
import com.tbuk.psd2.service.AuthServ;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value="/Auth",description="Authorisation Service",produces ="application/json")
@RequestMapping(value="/Auth")
public class AuthService {
 
	@Autowired
	AuthServ service;
  	
	@RequestMapping(value="/getAuthorisation",method=RequestMethod.GET)
	public ResponseEntity<BankAuthorization> getAccounts(@ModelAttribute HttpHeaders headers)  {
		BankAuthorization b= service.getAuthorisation();
		return new ResponseEntity<BankAuthorization>(b,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getPaymentUID/{accountId}",method=RequestMethod.GET)
	public ResponseEntity<PaymentUID> getAccountDetail(@ModelAttribute HttpHeaders headers, @PathVariable("accountId") String accountId)  {

		return new ResponseEntity<PaymentUID>(service.getPaymentUID(),HttpStatus.OK);// HttpStatus.OK=200
	}


	
	  //Header'i tekrar tekrar her metoda eklememek icin
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

