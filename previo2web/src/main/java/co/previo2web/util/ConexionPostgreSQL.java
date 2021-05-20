package co.previo2web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionPostgreSQL {
	
	private Connection con=null;
	private static ConexionPostgreSQL db;
	private PreparedStatement preparedStatement;
	
	//String host="queenie.db.elephantsql.com";
	//String db="mnjgxshj";
	
	private static final String url="jdbc:postgresql://queenie.db.elephantsql.com:5432/mnjgxshj";
	private static final String dbName="mnjgxshj";
	private static final String driver="org.postgresql.Driver";
	private static final String userName="mnjgxshj";
	private static final String password="Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	
	
	
	@SuppressWarnings("deprecation")
	public ConexionPostgreSQL() {
		
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url+dbName,userName,password);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion()
	{
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static ConexionPostgreSQL getConexion()
	{
		if(db == null)
		{
			db = new ConexionPostgreSQL();
		}
		return db;
			
	}
	
	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	public int excecute() throws SQLException
	{
		int result = preparedStatement.executeUpdate();
		return result;
	}
	
	public Connection getCon()
	{
		return this.con;
	}
	
	public PreparedStatement setprePreparedStatement (String sql) throws SQLException
	{
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
	
	
	
	/*
	 * public Statement st=null;
	
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
	
	public ResultSet consultar(String sql)
	{
		try {
			Statement st = this.con.createStatement();
			
			//ResultSet rs = st.executeQuery("select * from country");
			ResultSet rsc = st.executeQuery(sql);
			//while(rs.next())
			//{
				//String name= rs.getString("name");
		
				//System.out.println("El nombre es: " + name);
			//}
			
			while(rsc.next())
			{
				String nameCiclista = rsc.getString("name");
				String country = rsc.getString("country");
				
				System.out.println("El ciclista " + nameCiclista + " es de " + country);
			}
			
			return rsc;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static void main(String[] args)
	{
		ConexionPostgreSQL conexion = new ConexionPostgreSQL();
		
		
		
		
		conexion.cerrarConexion();
	}
	 */
///
	
}
