package com.demo.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Guest;
import com.demo.entities.Host;

/**
 * Servlet implementation class GuestServlet
 */
@WebServlet("/guest")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB:
    @EJB GuestDao guestDao;
    
 // Injected DAO EJB:
    @EJB HostDao hostDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setAttribute("guests", guestDao.getAllGuests());
		 request.setAttribute("hosts", hostDao.getAllHosts());
		 System.out.println(hostDao.getAllHosts());
		 
		 for (Guest gues: guestDao.getAllGuests()) {
			 System.out.println("-----------Guests---------  "+  gues.getHost().getGuests());
		 }
	     request.getRequestDispatcher("/guest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Handle a new guest:
        String name = request.getParameter("name");
        
        System.out.println("=====================HOSTS================"  +request.getParameter("host"));
        Host host = new Host( Integer.parseInt(request.getParameter("host")));
        
   //     System.out.println("-----HOST-------"+  request.getParameter("host"));
        if (name != null)
            guestDao.persist(new Guest(name, host));
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
