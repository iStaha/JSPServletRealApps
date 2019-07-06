package com.demo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/account")
public class AcountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AcountServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			request.getRequestDispatcher("account/login.jsp").forward(request, response);
		} else {
			if (action.equalsIgnoreCase("logout")) {
				HttpSession session = request.getSession();
				session.removeAttribute("username");
				response.sendRedirect("account");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
			session.setAttribute("username", username);
			request.getRequestDispatcher("account/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Invalid Account");
			request.getRequestDispatcher("account/login.jsp").forward(request, response);
		}
	}

}