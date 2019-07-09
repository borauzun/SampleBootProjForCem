package com.tbuk.psd2.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tbuk.psd2.model.ais.AccountDetail;
import com.tbuk.psd2.model.ais.AccountTransaction;
import com.tbuk.psd2.model.ais.Statement;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.model.payment.Charge;
import com.tbuk.psd2.model.response.BankAuthorization;
import com.tbuk.psd2.service.AisService;
import com.tbuk.psd2.service.PaymentService;

import io.swagger.annotations.Api;

@RestController
@Api(value="/accountlinking",description="Account Information Service",produces ="application/json")
@RequestMapping(value="/accountlinking")
public class AccountLinkingServ {
 
	@Autowired
	AisService service;
	
	@GetMapping("/servletcontroller")
    public ModelAndView redirectWithUsingForwardPrefix(ModelMap model,@ModelAttribute HttpHeaders headers) {
		return new ModelAndView("redirect:" + "http://localhost?");
    }
	
	@GetMapping("/getAuthorisation")
    public ResponseEntity<BankAuthorization> getAuthorisation(ModelMap model) {
		
		return new ResponseEntity<BankAuthorization>(new BankAuthorization(),HttpStatus.OK);
    }
	
	
	  //Header'i tekrar tekrar her metoda eklememek icin
		@ModelAttribute
		public HttpHeaders getHeaders(@RequestHeader(value="client_id", required = false) String client_Id,
				                        @RequestHeader(value="client_secret", required = false) String client_secret,
				                        @RequestHeader(value="scope", required = false) String scope,
				                        @RequestHeader(value="Content-Type", required = false) String contentType,
				                        @RequestHeader(value="x-fapi-customer-ip-address", required = false) String psuIp,
				                        @RequestHeader(value="Authorization", required = false) String jwtToken
				                        
				) 
		{
			
		  return new HttpHeaders();
		}

}

