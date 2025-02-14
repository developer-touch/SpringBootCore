package com.ankit.sbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("stdAdd")
@Data
public class StudentAddmission {
	
	//injecting values by collecting them from the properties file
	@Value("${std.no}")
	private Integer stdNo;
	@Value("${std.name}")
	private String stdName;
	@Value("${std.addrs}")
	private String stdAddrs;
	
	//injecting values after performing SPEL activity
	@Value("#{catalog.cLangFee+catalog.jLangFee+catalog.sfFee+catalog.sbmsFee}")
	private Integer courseFee;
	
	//validate the course fee
	@Value("#{catalog.cLangFee>400}")
	private boolean isCourseFee;
	
	//hard coding
	@Value("7894")
	private Integer mobile;
	
	//injecting system properties from the environment
	@Value("${user.name}")
	private String username;
	@Value("${os.name}")
	private String osName;
	@Value("${Path}")
	private String pathData;
	
	//injecting StudentCatalog object
	@Autowired
	private CourseCatalog catalog;
	
	public StudentAddmission() {
		System.out.println("StudentAddmission::0-arg constructor");
	}
}
