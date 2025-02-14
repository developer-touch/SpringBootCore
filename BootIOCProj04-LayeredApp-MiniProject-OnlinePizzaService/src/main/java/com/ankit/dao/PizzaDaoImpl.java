//PizzaDaoImpl.java
package com.ankit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.model.Pizza;

@Component("pDAO")
public class PizzaDaoImpl implements IPizzaDAO {

	private static final String GET_PIZZA_BY_ONE_VAR = """
			SELECT 
			orderid,varieties,size,price 
			FROM pizza WHERE
			varieties IN(?,?,?,?) 
			AND
			size IN(?);
			""";
	private static final String GET_PIZZA_BY_TWO_VAR = "select ORDERID,VARIETIES,SIZE,PRICE from PIZZA where VARIETIES in(?,?) and SIZE in(?)";
	private static final String GET_PIZZA_BY_THREE_VAR = "select ORDERID,VARIETIES,SIZE,PRICE from PIZZA where VARIETIES in(?,?,?) and SIZE in(?)";
	private static final String ADD_PIZZA_DETAILS = "insert into PIZZA(ORDERID,VARIETIES,SIZE,PRICE) values (?,?,?,?)";
	
	public PizzaDaoImpl() {
		System.out.println("PizzaDaoImpl::0-arg constructor)");
	}

	// inject data source object for get pooled connection
	@Autowired
	private DataSource ds;

	@Override
	public List<Pizza> fetchPizzaByVarities(String item, String size) throws Exception {
		System.out.println("PizzaDaoImpl.fetchPizzaByVarities()");
		// creating ArrayList class object
		ArrayList<Pizza> pList = null;
		
		try (Connection con = ds.getConnection();
				// creating PS object having SQL query
				PreparedStatement ps = con.prepareStatement(GET_PIZZA_BY_ONE_VAR);) {
			// set value to QP
			ps.setString(1, item);
			ps.setString(2, size);
			
			// execute the query
			try (ResultSet rs = ps.executeQuery();) {
				// assigning object to ArrayList
				
				pList = new ArrayList<Pizza>();
				// process the result
				
				while (rs.next()) {
					Pizza p = new Pizza();
					p.setOrderId(rs.getInt(1));
					p.setVarieties(rs.getString(2));
					p.setSize(rs.getString(3));
					p.setPrice(rs.getDouble(4));
					// adding Pizza object pList
					pList.add(p);
				}
			}
		} 
		catch (SQLException se) {
			throw se;
		} 
		catch (Exception e) {
			throw e;
		}
		return pList;
	}

	@Override
	public List<Pizza> fetchPizzaByVarities(String item1, String item2, String size) throws Exception {
		System.out.println("PizzaDaoImpl.fetchPizzaByVarities()");
		// creating ArrayList class object
		
		ArrayList<Pizza> pList = null;
		try (Connection con = ds.getConnection();
				// creating PS object having SQL query
				PreparedStatement ps = con.prepareStatement(GET_PIZZA_BY_TWO_VAR);) {
			// set value to QP
			ps.setString(1, item1);
			ps.setString(2, item2);
			ps.setString(3, size);
			
			// execute the query
			try (ResultSet rs = ps.executeQuery();) {
				// assigning object to ArrayList
				pList = new ArrayList<Pizza>();
				// process the result
				
				while (rs.next()) {
					Pizza p = new Pizza();
					p.setOrderId(rs.getInt(1));
					p.setVarieties(rs.getString(2));
					p.setSize(rs.getString(3));
					p.setPrice(rs.getDouble(4));
					// adding Pizza object pList
					pList.add(p);
				}
			}
		} 
		catch (SQLException se) {
			throw se;
		} 
		catch (Exception e) {
			throw e;
		}
		return pList;
	}

	@Override
	public List<Pizza> fetchPizzaByVarities(String item1, String item2, String item3, String size) throws Exception {
		System.out.println("PizzaDaoImpl.fetchPizzaByVarities()");
		// creating ArrayList class object
		ArrayList<Pizza> pList = null;
		
		try (Connection con = ds.getConnection();
				// creating PS object having SQL query
				PreparedStatement ps = con.prepareStatement(GET_PIZZA_BY_THREE_VAR);) {
			// set value to QP
			ps.setString(1, item1);
			ps.setString(2, item2);
			ps.setString(3, item3);
			ps.setString(4, size);
			
			// execute the query
			try (ResultSet rs = ps.executeQuery();) {
				// assigning object to ArrayList
				pList = new ArrayList<Pizza>();
				
				// process the result
				while (rs.next()) {
					Pizza p = new Pizza();
					p.setOrderId(rs.getInt(1));
					p.setVarieties(rs.getString(2));
					p.setSize(rs.getString(3));
					p.setPrice(rs.getDouble(4));
					
					// adding Pizza object pList
					pList.add(p);
				}
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		}
		return pList;
	}

	@Override
	public int insertOnePizzaDetails(Pizza pizza) throws Exception {
		System.out.println("PizzaDaoImpl.insertOnePizzaDetails()");
		int result = 0;
		try(Connection con = ds.getConnection();
				//create PS object having SQL query
				PreparedStatement ps = con.prepareStatement(ADD_PIZZA_DETAILS);){
			//set values to QP
			ps.setInt(1,pizza.getOrderId());
			ps.setString(2, pizza.getVarieties());
			ps.setString(3, pizza.getSize());
			ps.setDouble(4, pizza.getPrice());
			
			//execute the query
			result = ps.executeUpdate();
		}
		catch (SQLException se) {
			throw se;
		}
		catch (Exception e) {
			throw e;
		}
		return result;
	}

}
