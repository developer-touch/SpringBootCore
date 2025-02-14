//JobDetails.java
package com.ankit.sbean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("jd")
@ConfigurationProperties(prefix = "org.jd")
public class JobDetails {
	private Integer jobId;
	private String desg;
	private String company;
	private Integer salary;
}
