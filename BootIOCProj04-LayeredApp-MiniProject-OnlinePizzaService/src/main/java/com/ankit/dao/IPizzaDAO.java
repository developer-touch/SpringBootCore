package com.ankit.dao;

import java.util.List;

import com.ankit.model.Pizza;

public interface IPizzaDAO {
	public List<Pizza> fetchPizzaByVarities(String item,String size) throws Exception;
	public List<Pizza> fetchPizzaByVarities(String item1,String item2, String size) throws Exception;
	public List<Pizza> fetchPizzaByVarities(String item1,String item2,String item3, String size) throws Exception;
	public int insertOnePizzaDetails(Pizza pizza) throws Exception;
}
