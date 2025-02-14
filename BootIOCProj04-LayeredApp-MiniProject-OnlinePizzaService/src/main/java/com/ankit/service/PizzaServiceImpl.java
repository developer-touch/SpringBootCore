package com.ankit.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.dao.PizzaDaoImpl;
import com.ankit.model.Pizza;

@Component("pService")
public class PizzaServiceImpl implements IPizzaService {
	
	public PizzaServiceImpl() {
		System.out.println("PizzaServiceImpl::0-arg constructor");
	}

	//injecting PizzaDaoImp class object
	@Autowired
	private PizzaDaoImpl pDAO;
	
	@Override
	public List<Pizza> getPizzaByVarities(String item, String size) throws Exception {
		System.out.println("PizzaServiceImpl.getPizzaByVarities()");
		//changing varieties to upper case
		item = item.toUpperCase();
		
		//invoking pDAO class method
		List<Pizza> pList = pDAO.fetchPizzaByVarities(item, size);
		
		//calculating totalPrice of items
		pList.forEach(p->{
			p.setTotalPrice(p.getPrice());
		});
		
		//sort the pList by item name
		pList.sort(new Comparator<Pizza>() {
			@Override
			public int compare(Pizza p1, Pizza p2) {
				return p1.getVarieties().compareTo(p2.getVarieties());
			}
		});
		
		//returning pList object
		return pList;
	}

	@Override
	public List<Pizza> getByVarities(String item1, String item2, String size) throws Exception {
		System.out.println("PizzaServiceImpl.getByVarities()");
		//changing items name to upper case
		item1 = item1.toUpperCase();
		item2 = item2.toUpperCase();
		
		//invoking pDAO class method
		List<Pizza> pList = pDAO.fetchPizzaByVarities(item1, item2, size);
		
		//calculate the totalPrice of items
		pList.forEach(p->{
			p.setTotalPrice(p.getPrice()*2);
		});
		
		//sort the pList by items name
		pList.sort(new Comparator<Pizza>() {
			@Override
			public int compare(Pizza p1, Pizza p2) {
				return p1.getVarieties().compareTo(p2.getVarieties());
			}
		});
		
		//return list of Pizza object
		return pList;
	}

	@Override
	public List<Pizza> getPizzaByVarities(String item1, String item2, String item3, String size) throws Exception {
		System.out.println("PizzaServiceImpl.getPizzaByVarities()");
		//changing items name to upper case
		item1 = item1.toUpperCase();
		item2 = item2.toUpperCase();
		item3 = item3.toUpperCase();
		
		//invoke pDAO class method
		List<Pizza> pList = pDAO.fetchPizzaByVarities(item1, item2, item3, size);
		
		//calculate the total amount of items
		pList.forEach(p->{
			p.setTotalPrice(p.getPrice());
		});
		
		//sort the pList by items
		pList.sort(new Comparator<Pizza>() {
			@Override
			public int compare(Pizza p1, Pizza p2) {
				return p1.getVarieties().compareTo(p2.getVarieties());
			}
		});
		
		//return list Pizza object
		return pList;
	}

	@Override
	public int addOnePizzaDetails(Pizza pizza) throws Exception {
		System.out.println("PizzaServiceImpl.addOnePizzaDetails()");
		int result = 0;
		if (pDAO!=null) {
			result = pDAO.insertOnePizzaDetails(pizza);
		}
		else {
			throw new IllegalArgumentException("Pizza service class is null");
		}
		return result;
	}

	
}
