package co.previo2web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.previo2web.dao.CountryDao;
import co.previo2web.dto.Country;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CountryDao countryDao;

    /**
     * Default constructor. 
     */
    public CountryServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.countryDao = new CountryDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch(action)
			{
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertarCountry(request, response);
					break;
				case "/delete":
					eliminarCountry(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					actualizarCountry(request, response);
					break;
					default:
						listCountrys(request, response);
						break;
			
			}
		}catch(SQLException e){
			throw new ServletException(e);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("country.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String name=request.getParameter("name");
		
		Country country= new Country(name);
		
		countryDao.insert(country);
		 
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		
		Country countryActual = countryDao.select(id);
		
		request.setAttribute("country", countryActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("country.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void actualizarCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException
	{
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		
		Country country= new Country(id, name);
		
		countryDao.update(country);
		 
		response.sendRedirect("list");
	}
	
	private void eliminarCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException
	{
		String id=request.getParameter("id");
		
		
		countryDao.delete(id);
		 
		response.sendRedirect("list");
	}
	
	public void listCountrys(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException
	{
		List <Country> listCountrys = countryDao.selectAll();
		request.setAttribute("listCountrys", listCountrys);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("countrylist.jsp");
		dispatcher.forward(request, response);
	}
	
	

}
