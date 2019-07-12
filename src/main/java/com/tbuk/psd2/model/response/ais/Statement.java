package com.tbuk.psd2.model.response.ais;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.tbuk.psd2.model.common.Date;
import com.tbuk.psd2.model.common.DateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Statement {
	
	private String fileName;
	private Date statementDate;
	private String base64StatementFile;

}
