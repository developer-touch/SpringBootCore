package com.ankit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.model.Pizza;
import com.ankit.service.PizzaServiceImpl;

@Component("pCont")
public class PizzaController {

	public PizzaController() {
		System.out.println("PizzaController::0-arg constructor");
	}
	
	//injecting pService class object
	@Autowired
	private PizzaServiceImpl pService;
	
	//invoke the method of pService class
	public List<Pizza> orderPizza(String item,String size) throws Exception{
		System.out.println("PizzaController.orderPizza()");
		if(pService!=null) {
			return pService.getPizzaByVarities(item, size);
		}
		else {
			throw new IllegalArgumentException("Invalid Items name, please enter valid items name");
		}
	}
	
	public List<Pizza> orderPizza(String item1,String item2,String size) throws Exception{
		System.out.println("PizzaController.orderPizza()");
		if(pService!=null) {
			return pService.getByVarities(item1, item2, size);
		}
		else {
			throw new IllegalArgumentException("Invalid Items name, please enter valid items name");
		}
	}
	
	public List<Pizza> orderPizza(String item1,String item2,String item3,String size) throws Exception{
		System.out.println("PizzaController.orderPizza()");
		if(pService!=null) {
			return pService.getPizzaByVarities(item1, item2, item3, size);
		}
		else {
			throw new IllegalArgumentException("Invalid Items name, please enter valid items name");
		}
	}
	
	public int registerOnePizza(Pizza pizza) throws Exception{
		System.out.println("PizzaController.registerPizza()");
		int result = pService.addOnePizzaDetails(pizza);
		return result;
	}
	
}
