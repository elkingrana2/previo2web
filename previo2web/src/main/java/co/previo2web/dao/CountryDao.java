package co.previo2web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.previo2web.dto.Country;
import co.previo2web.util.ConexionPostgreSQL;

public class CountryDao  {
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_country_SQL ="INSERT INTO country (name) VALUES (?)";
	private static final String DELETE_country_SQL ="DELETE FROM country WHERE id = ?;";
	private static final String UPDATE_country_SQL ="UPDATE country SET id = ? , SET name = ? WHERE id = ?;";
	private static final String SELECT_country_BY_ID ="SELECT * FROM country WHERE id = ?;";
	private static final String SELECT_ALL_countrys ="SELECT * FROM country;";
	
	public CountryDao()
	{
		this.conexion = ConexionPostgreSQL.getConexion();
	}
	
	public void insert(Country country) throws SQLException
	{
		try {
			PreparedStatement preparedStatement = conexion.setprePreparedStatement(INSERT_country_SQL);
			preparedStatement.setString(1, country.getName());
			conexion.excecute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void delete(String id) throws SQLException
	{
		try {
			PreparedStatement preparedStatement = conexion.setprePreparedStatement(DELETE_country_SQL);
			preparedStatement.setString(1, id);
			conexion.excecute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void update(Country country) throws SQLException
	{
		try {
			PreparedStatement preparedStatement = conexion.setprePreparedStatement(UPDATE_country_SQL);
			preparedStatement.setString(1, country.getName());
			preparedStatement.setString(2, country.getId());
			conexion.excecute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Country> selectAll()
	{
		List <Country> paises = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setprePreparedStatement(SELECT_ALL_countrys);
			
			ResultSet rs = conexion.query();
			
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				paises.add(new Country(id, name));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return paises;
		
	}
	
	public Country select(String id)
	{
		Country pais = null;
		
		try {
			PreparedStatement preparedStatement = conexion.setprePreparedStatement(SELECT_country_BY_ID);
			preparedStatement.setString(1, id);
			ResultSet rs = conexion.query();
			
			while(rs.next())
			{
				String name = rs.getString("name");
				pais = new Country(id, name);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return pais;
		
	}

	
	
	
	
	/*
	 * public Country get(String name)
	{
		ConexionPostgreSQL conexion=new ConexionPostgreSQL();
		String sql="Select * from country where name="+ name;
		ResultSet rs = conexion.consultar(sql);
		
		Country pais= new Country();
		
		try {
			while(rs.next())
			{
				pais.setName(rs.getString("name"));
				pais.setId(rs.getString("id"));
				
				return pais;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
		return pais;
	}
	
	

	 */
	
}	
