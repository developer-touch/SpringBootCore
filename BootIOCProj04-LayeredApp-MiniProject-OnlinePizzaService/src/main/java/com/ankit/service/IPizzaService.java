package com.ankit.service;

import java.util.List;

import com.ankit.model.Pizza;

public interface IPizzaService {
	public List<Pizza> getPizzaByVarities(String item,String size) throws Exception;
	public List<Pizza> getByVarities(String item1,String item2, String size) throws Exception;
	public List<Pizza> getPizzaByVarities(String item1,String item2,String item3, String size) throws Exception;
	public int addOnePizzaDetails(Pizza pizza) throws Exception;
}
