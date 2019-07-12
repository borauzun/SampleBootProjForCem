package com.tbuk.psd2.model.common;

import java.time.LocalDateTime;

import com.tbuk.psd2.model.enums.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrpHdr {
	
	private String referenceId;
	private DateTime CreDtTm;



}
