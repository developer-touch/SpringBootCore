//Employee.java
package com.ankit.sbean;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("emp")
@ToString
@Setter
@ConfigurationProperties(prefix = "org.ankit")
public class Employee {
	private Integer eno;
	private String ename;
	private String eaddrs;
	private String[] favDesg;
	private List<String> friends;
	private Set<Long> phones;
	private Map<String, Long> idDetails;
	private JobDetails details;
	
	public Employee() {
		System.out.println("Employee::0-arg constructor");
	}
}	
