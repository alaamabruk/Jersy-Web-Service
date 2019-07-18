package com.Jersy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Alien_Repositry {

	

	List<Alien> aliens = new ArrayList<>();
    Connection con = null;
	public Alien_Repositry() {
		
		String username="root";
        String password="3122";
        String url="jdbc:mysql://localhost/alpha";
        
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public List<Alien> get_Aliens() {
		String sql = "select * from alien" ;
		
		try {
			
			
			Statement st = con.createStatement();
		    ResultSet res =	st.executeQuery(sql);
				
		    while (res.next()) {
		    	
		    	 Alien a = new Alien();
		    	 a.setId(res.getInt(1));
			     a.setName(res.getString(2));
			     a.setPoint(res.getInt(3));
			     
				aliens.add(a);	
				}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return aliens;
		}
	
	
	public Alien get_Alien(int id) {	
    
		Alien a = new Alien();
		try {
			
			String sql = "select * from alien where id= "+id ;
			Statement st = con.createStatement();
		    ResultSet res =	st.executeQuery(sql);
				
		   if(res.next()) {
		    	
		    	 a.setId(res.getInt(1));
			     a.setName(res.getString(2));
			     a.setPoint(res.getInt(3));
			     
				}
		} catch (Exception e) {
			System.out.println(e);
		}
			return a;
	}


	public void create(Alien a3) {
     
		try {
			
			String sql = "insert into alien values (?,?,?)" ;
			PreparedStatement prs = con.prepareStatement(sql);
		    prs.setInt(1, a3.getId());
		    prs.setString(2, a3.getName());
		    prs.setInt(3, a3.getPoint());
		    prs.executeUpdate();
				
		 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void update(Alien a3) {
	     
		try {
			
			String sql = "update alien set name =? , point =? where id=? " ;
			PreparedStatement prs = con.prepareStatement(sql);
		    
		    prs.setString(1, a3.getName());
		    prs.setInt(2, a3.getPoint());
		    prs.setInt(3, a3.getId());
		    prs.executeUpdate();
				
		 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
	     
		try {
			
			String sql = "delete from alien where id=? " ;
			PreparedStatement prs = con.prepareStatement(sql);
		 
		    prs.setInt(1, id);
		    prs.executeUpdate();
				
		 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
