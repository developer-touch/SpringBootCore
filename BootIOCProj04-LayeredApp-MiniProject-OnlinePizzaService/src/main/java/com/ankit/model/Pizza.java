//Pizza.java
package com.ankit.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pizza")
@Data
public class Pizza {
	private Integer orderId;
	private String varieties;
	private String size;
	private Double price;
	private Double totalPrice;
}
