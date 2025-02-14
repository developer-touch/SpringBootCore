package com.ankit.sbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("catalog")
@Data
public class CourseCatalog {

	@Value("${std.cfee}")
	private Integer cLangFee;
	@Value("${std.jfee}")
	private Integer jLangFee;
	@Value("${std.advjfee}")
	private Integer advJFee;
	@Value("${std.sffee}")
	private Integer sfFee;
	@Value("${std.sbmsfee}")
	private Integer sbmsFee;
	@Value("${std.awsfee}")
	private Integer awsFee;
	@Value("${std.uifee}")
	private Integer uiFee;
	@Value("${std.oraclefee}")
	private Integer oracleFee;
	
	public CourseCatalog() {
		System.out.println("CourseCatalog::0-arg constructor");
	}
	
}
