package com.tbuk.psd2.model.ais;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Statement {
	
	private String fileName;
	private LocalDate statementDate;
	private String base64StatementFile;

}
