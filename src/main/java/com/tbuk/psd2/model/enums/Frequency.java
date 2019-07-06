package com.tbuk.psd2.model.enums;

public enum Frequency {
	ONCE("GBP"),
	DAILY("GBP"),
	WEEKLY("USD"),
	MONTHLY("TRY");
	
		
		String frequency;
		Frequency(String frequency){
			this.frequency=frequency;
		}
		
		public String getFrequency() {return this.frequency;}
}
