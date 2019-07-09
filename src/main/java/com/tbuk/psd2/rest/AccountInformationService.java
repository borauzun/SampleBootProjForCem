package com.tbuk.psd2.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbuk.psd2.model.ais.AccountDetail;
import com.tbuk.psd2.model.ais.AccountTransaction;
import com.tbuk.psd2.model.ais.Statement;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.service.AisService;
import com.tbuk.psd2.service.PaymentService;

import io.swagger.annotations.Api;

@RestController
@Api(value="/AccountInformation",description="Account Information Service",produces ="application/json")
@RequestMapping(value="/AccountInformation")
public class AccountInformationService {
 
	@Autowired
	AisService service;
  
  	
	@RequestMapping(value="/getAccountsList",method=RequestMethod.GET)
	public ResponseEntity<List<BankAccount>> getAccounts(@ModelAttribute HttpHeaders headers)  {
		List<BankAccount> list=service.getAccountsList();
		return new ResponseEntity<List<BankAccount>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAccountDetail/{accountId}",method=RequestMethod.GET)
	public ResponseEntity<AccountDetail> getAccountDetail(@ModelAttribute HttpHeaders headers,@PathVariable("accountId") String accountId)  {
		AccountDetail account=service.getAccountDetail();
		return new ResponseEntity<AccountDetail>(account,HttpStatus.OK);// HttpStatus.OK=200 
	}
	
	@RequestMapping(value="/getAccountTransactions/{accountId}/{dateFrom}/{dateTo}",method=RequestMethod.GET)
	public ResponseEntity<List<AccountTransaction>> getAccountTransactions(@ModelAttribute HttpHeaders headers,@PathVariable("accountId") String accountId)  {
		List<AccountTransaction> list=service.getAccountTransactions();
		return new ResponseEntity<List<AccountTransaction>>(list,HttpStatus.OK);// HttpStatus.OK=200 
	}
	@RequestMapping(value="/getStatement/{accountId}/{month}/{year}",method=RequestMethod.GET)
	public ResponseEntity<Statement> getStatement(@ModelAttribute HttpHeaders headers,@PathVariable("accountId") String accountId)  {
		Statement statement=service.getStatement();
		return new ResponseEntity<Statement>(statement,HttpStatus.OK);// HttpStatus.OK=200 
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

