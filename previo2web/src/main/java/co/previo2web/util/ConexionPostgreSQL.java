package co.previo2web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgreSQL {
	public Connection con;
	
	public ConexionPostgreSQL()
	{
		String host="queenie.db.elephantsql.com";
		String db="mnjgxshj";
		
		String url="jdbc:postgresql://"+host+":5432/"+db;
		String usuario="mnjgxshj";
		String pass = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
		
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
		
	
	
	con = DriverManager.getConnection(url,usuario,pass);
			
	
	boolean valid = con.isValid(50000);
	System.out.println(valid ? "TEST OK" : "TEST FAIL");
	
	} catch (SQLException e)
	{
		e.printStackTrace();
		
	}
}
	
	public static void main(String[] args)
	{
		ConexionPostgreSQL javaPostgreSQLBasic = new ConexionPostgreSQL();
		
	}
}
