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

import com.tbuk.psd2.model.response.ais.AccountDetail;
import com.tbuk.psd2.model.response.ais.AccountTransaction;
import com.tbuk.psd2.model.response.ais.Statement;
import com.tbuk.psd2.model.common.BankAccount;
import com.tbuk.psd2.model.common.HttpHeaders;
import com.tbuk.psd2.service.AisService;

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
		AccountDetail account=service.getAccountDetail(accountId);
		return new ResponseEntity<AccountDetail>(account,HttpStatus.OK);// HttpStatus.OK=200 
	}

	@RequestMapping(value="/getBalance/{accountId}",method=RequestMethod.GET)
	public ResponseEntity<Double> getBalance(@ModelAttribute HttpHeaders headers,@PathVariable("accountId") String accountId)  {
		Double balance=service.getBalance(accountId);
		return new ResponseEntity<Double>(balance,HttpStatus.OK);// HttpStatus.OK=200
	}

	@RequestMapping(value="/getAccountTransactions/{accountId}/{dateFrom}/{dateTo}",method=RequestMethod.GET)
	public ResponseEntity<List<AccountTransaction>> getAccountTransactions(@ModelAttribute HttpHeaders headers,@PathVariable("accountId") String accountId,@PathVariable("dateFrom") String dateFrom,@PathVariable("dateTo") String dateTo)  {
		List<AccountTransaction> list=service.getAccountTransactions();
		return new ResponseEntity<List<AccountTransaction>>(list,HttpStatus.OK);// HttpStatus.OK=200 
	}
	@RequestMapping(value="/getStatement/{accountId}/{month}/{year}",method=RequestMethod.GET)
	public ResponseEntity<Statement> getStatement(@ModelAttribute HttpHeaders headers,@PathVariable("accountId") String accountId
                                                                                     ,@PathVariable("month") int month
	                                                                                 ,@PathVariable("year") int year){
		Statement statement=service.getStatement();
		return new ResponseEntity<Statement>(statement,HttpStatus.OK);// HttpStatus.OK=200 
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

