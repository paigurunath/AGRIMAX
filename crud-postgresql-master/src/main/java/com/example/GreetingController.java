package com.example;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.predix.dao.AppoinmentDetails;
import com.predix.dao.TableDataOperations;
import com.predix.model.Company;
import com.predix.model.User;

@RestController
public class GreetingController {

	@RequestMapping("/")
	String home() {
		return "Hello I am from Postgresql!!!!";
	}
	
    @RequestMapping(value="/createTable", method=RequestMethod.POST)
	public String createTable() {
		try {
			TableDataOperations tdo = new TableDataOperations();
			return tdo.createTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/insertTableData", method=RequestMethod.POST)
	public String insertTableData(@RequestBody Company company ) {
		try {
			TableDataOperations tdo = new TableDataOperations();
			
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getAppname());
			hm.put(new Integer(2), company.getStatus());
			
			return tdo.insertDataTable(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/updateTableData", method=RequestMethod.POST)
	public String updateTableData(@RequestBody Company company ) {
		try {
			TableDataOperations tdo = new TableDataOperations();
			
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getStatus());
			hm.put(new Integer(2), company.getAppname());
			
			return tdo.updateDataTable(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping(value="/retrieveTableData", method=RequestMethod.POST)
	public @ResponseBody String retrieveTableData(@RequestBody Company company) {
		try {
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), company.getAppname());
			
			TableDataOperations tdo = new TableDataOperations();
			return tdo.viewData(hm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public String insertUser(@RequestBody User user) {
		try {
			AppoinmentDetails ad = new AppoinmentDetails();
			
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(new Integer(1), user.getName());
			hm.put(new Integer(2), user.getType());
			
			return ad.insertUser(hm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
}