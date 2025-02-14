//Employee.java
package com.ankit.sbean;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("emp")
@ConfigurationProperties(prefix = "org.emp")
public class Employee {
	private Integer eno;
	private String ename;
	private String egender;
	private String eaddrs;
	private Long econtact;
	
	private String[] favDesg;
	private List<Integer> salaryChoice;
	private Set<String> friends;
	private Map<String, Long> idDetails;
	private JobDetails details;
}
