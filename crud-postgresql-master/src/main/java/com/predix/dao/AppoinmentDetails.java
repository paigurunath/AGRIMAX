package com.predix.dao;

import java.util.HashMap;

import com.predix.datasource.Query;
import com.predix.datasource.QueryInteractor;

public class AppoinmentDetails {

	QueryInteractor qi = null;
	
	public String insertUser(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.INSERT_DOCTOR, values);
 			
 			return "SUCCESS";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
}
