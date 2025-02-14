package com.ankit;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ankit.controller.PizzaController;
import com.ankit.model.Pizza;

@SpringBootApplication
public class BootIocProj04LayeredAppMiniProjectOnlinePizzaServiceApplication {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext context = SpringApplication.run(BootIocProj04LayeredAppMiniProjectOnlinePizzaServiceApplication.class, args);
		//get target spring bean class object reference
		PizzaController pController = context.getBean("pCont", PizzaController.class);
		
		//create Scanner class object reference
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the varieties quantities (1-3)");
		int qnty = scn.nextInt();
		System.out.println("Enter the varieties size(Regular,Medium,Large)");
		String size = scn.next();
		
		//creating Pizza list class object
		List<Pizza> pList = null;
		
		//view pizza details
		try {
			if(qnty==1) {
				System.out.println("Enter the varieties name :: ");
				String item = scn.next();
				
				//invoke the b.method
				pList = pController.orderPizza(item, size);
				pList.forEach(System.out::println);
			}
			else if(qnty==2) {
				System.out.println("Enter the first varieties name :: ");
				String item1 = scn.next();
				System.out.println("Enter the second varieties name :: ");
				String item2 = scn.next();
				
				//invoke the b.method
				pList = pController.orderPizza(item1,item2, size);
				pList.forEach(System.out::println);
			}
			else if(qnty==3) {
				System.out.println("Enter the first varieties name :: ");
				String item1 = scn.next();
				System.out.println("Enter the second varieties name :: ");
				String item2 = scn.next();
				System.out.println("Enter the third varieties name :: ");
				String item3 = scn.next();
				
				//invoke the b.method
				pList = pController.orderPizza(item1,item2,item3,size);
				pList.forEach(System.out::println);
			}
			else {
				throw new IllegalArgumentException("Please enter quantity between (1-3)");
			}
		}
		catch (Exception e) {
			System.err.println("Internal problem, please try again.."+e.getMessage());
		}
		
		System.out.println("<<<<<<<<<<<<<< ADD OPERATION >>>>>>>>>>>>>");
		
		//add pizza details 
		try{
			System.out.println("Enter the varieties name ::");
			String item = scn.next();
			System.out.println("Enter the size(Regular,Medium,Large) :: ");
			String itemSize = scn.next();
			System.out.println("Enter the price :: ");
			double price = scn.nextDouble();
			
			//add to pizza object
			Pizza p = new Pizza();
			p.setOrderId(new Random().nextInt(100));
			p.setVarieties(item);
			p.setSize(itemSize);
			p.setPrice(price);
			
			//invoke the method
			int pizzaRegistered = pController.registerOnePizza(p);
			System.out.println(pizzaRegistered);
		}
		catch (Exception e) {
			System.err.println("Internal problem, please try again.."+e.getMessage());
		}
		
		//close the container
		((ConfigurableApplicationContext) context).close();
	}

}
