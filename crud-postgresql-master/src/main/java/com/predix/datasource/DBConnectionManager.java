package com.predix.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnectionManager {

	Properties props = new Properties();
	Connection con = null;

	String CLASS_NAME = this.getClass().getName();
	Logger logger = Logger.getLogger(CLASS_NAME);

	public Connection getConnection() {
		
		logger.info("Entering " + CLASS_NAME);

		try {

	//	File Path =new File("resources/mars.properties");
		
	
			//FileInputStream fis = new FileInputStream(Path.getAbsolutePath());

//System.out.println(Path.getAbsolutePath());

			
			//FileInputStream fis = new FileInputStream("D:/mars/resources/mars.properties");

		

	       // props.load(fis);
			
			/*Class.forName(props.getProperty("jdbc.driver"));
			con = DriverManager.getConnection(props.getProperty("jdbc.connectionurl"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
			
			
			"credentials": {
     "ID": 0,
     "binding_id": "aca11dcb-9f60-4a71-8970-d908a23b4927",
     "database": "d4f75b567496b451faab35fbf9dfb09b3",
     "dsn": "host=10.72.6.143 port=5432 user=u7464a12a5e524cd4a4ec5bce7292c339 password=1077626664524c6695b5244ca8402113 dbname=d4f75b567496b451faab35fbf9dfb09b3 connect_timeout=5 sslmode=disable",
     "host": "10.72.6.143",
     "instance_id": "6d8e9aeb-4028-4828-9783-01d08591e014",
     "jdbc_uri": "jdbc:postgresql://10.72.6.143:5432/d4f75b567496b451faab35fbf9dfb09b3?user=u7464a12a5e524cd4a4ec5bce7292c339\u0026password=1077626664524c6695b5244ca8402113\u0026ssl=false",
     "password": "1077626664524c6695b5244ca8402113",
     "port": "5432",
     "uri": "postgres://u7464a12a5e524cd4a4ec5bce7292c339:1077626664524c6695b5244ca8402113@10.72.6.143:5432/d4f75b567496b451faab35fbf9dfb09b3?sslmode=disable",
     "username": "u7464a12a5e524cd4a4ec5bce7292c339"
    },
    "label": "postgres",
    "name": "agro_mac_db",
    "plan": "shared-nr",
    "provider": null,
    "syslog_drain_url": null,
    "tags": [
     "rdpg",
     "postgresql"
    ],
    "volume_mounts": []
   }

			*/
	        //	jdbc:mysql://localhost:3306/dbname
	        Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","pgadmin");
			//con = DriverManager.getConnection("jdbc:postgresql://10.72.6.143:5432/d4f75b567496b451faab35fbf9dfb09b3","u7464a12a5e524cd4a4ec5bce7292c339","1077626664524c6695b5244ca8402113");
			
			if (con != null) {
				logger.info("Connection created Successfully !");
				System.out.println("Connection created Successfully !");
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return con;
	}
	
	/*public static void main(String args[]) {
		DBConnectionManager dbc = new DBConnectionManager();
		dbc.getConnection();
	}*/
}