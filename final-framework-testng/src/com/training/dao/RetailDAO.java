package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.RegisterBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RetailDAO {
	
	Properties properties; 
	
	public RetailDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<RegisterBean> getRegister(){
		String sql = properties.getProperty("get.register"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RegisterBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RegisterBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				RegisterBean temp = new RegisterBean(); 
				temp.setfName(gc.rs1.getString(1));
				temp.setlName(gc.rs1.getString(2));
				temp.setEmail(gc.rs1.getString(3));
				temp.setTel(gc.rs1.getString(4));
				temp.setAdd1(gc.rs1.getString(5));
				temp.setAdd2(gc.rs1.getString(6));
				temp.setCity(gc.rs1.getString(7));
				temp.setPcode(gc.rs1.getString(8));
				temp.setCountry(gc.rs1.getString(9));
				temp.setRegion(gc.rs1.getString(10));
				temp.setPassword(gc.rs1.getString(11));
				temp.setConfirmPass(gc.rs1.getString(12));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RetailDAO().getRegister().forEach(System.out :: println);
	}
	
	
}
