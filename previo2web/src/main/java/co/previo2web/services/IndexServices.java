package co.previo2web.services;


import co.previo2web.dao.CountryDao;
import co.previo2web.dto.Country;

public class IndexServices {
	
	public Country obtenerNombre(String name)
	{
		CountryDao cDao = new CountryDao();
		Country c= cDao.get(name);
		
		return c;
	}
	
	

}
