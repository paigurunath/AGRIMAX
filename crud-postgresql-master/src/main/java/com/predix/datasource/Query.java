package com.predix.datasource;

public class Query {

	public static String CREATE_AGRO = "CREATE TABLE  IF NOT EXISTS  agro  (appname text not null,status TEXT NOT NULL, primary key (appname))";
	public static String INSERT_AGRO = "INSERT INTO agro (appname, status) VALUES (?,?)";
	public static String UPDATE_AGRO = "UPDATE agro SET status = ? where appname = ?";
	public static String VIEW_AGRO = "SELECT status, appname FROM AGRO where appname=?";
	
}