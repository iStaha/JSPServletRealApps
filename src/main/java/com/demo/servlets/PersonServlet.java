package com.demo.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Person;
import com.demo.helpers.UploadFileHelper;

@WebServlet("/person")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
	maxFileSize = 1024 * 1024 * 50, // 50 MB
	maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class PersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIR = "assets/images";

	public PersonServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("account/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Person person = new Person();
		person.setUsername(request.getParameter("username"));
		person.setPassword(request.getParameter("password"));
		String photo = UploadFileHelper.uploadFile(UPLOAD_DIR, request);
		if (person != null) {
			person.setPhoto(photo);
		}
		request.setAttribute("person", person);
		request.getRequestDispatcher("account/sucessregister.jsp").forward(request, response);
	}

}