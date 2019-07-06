package com.tbuk.psd2.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="/AccountInformation",description="Account Information Service",produces ="application/json")
@RequestMapping(value="/AccountInformation")
public class AccountInformationService {
 
 
	@RequestMapping(value="/getAccountsList",method=RequestMethod.GET)
	public ResponseEntity<String> getAccounts()  {
		     return new ResponseEntity<String>("sample ",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAccountDetail/{accountId}",method=RequestMethod.GET)
	public ResponseEntity<String> getAccountDetail(@PathVariable("accountId") String accountId)  {
		return new ResponseEntity<String>("sample ",HttpStatus.OK);// HttpStatus.OK=200 
	}
	
	@RequestMapping(value="/getAccountTransactions",method=RequestMethod.GET)
	public ResponseEntity<String> getAccountTransactions(@PathVariable("accountId") String accountId)  {
		return new ResponseEntity<String>("sample ",HttpStatus.OK);// HttpStatus.OK=200 
	}

}

