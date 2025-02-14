//JobDetails.java
package com.ankit.sbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;
import lombok.val;

@Component("jd")
@ToString
@Setter
@ConfigurationProperties(prefix = "org.ankit")
public class JobDetails {
	private Integer jobId;
	private String desg;
	private String company;
	private Integer salary;
	@Value("10")
	private Integer deptNo;
	
	public JobDetails() {
		System.out.println("JobDetails::0-arg constructor");
	}
}
