package com.demo.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.demo.entities.Account;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AccountServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("account/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Account account = new Account();
			account.setUsername(request.getParameter("username"));
			account.setPassword(request.getParameter("password"));
			account.setAge(Integer.parseInt(request.getParameter("age")));
			account.setEmail(request.getParameter("email"));
			account.setWebsite(request.getParameter("website"));

			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);
			if (!constraintViolations.isEmpty()) {
				String errors = "<ul>";
				for (ConstraintViolation<Account> constraintViolation : constraintViolations) {
					errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
							+ "</li>";
				}
				errors += "</ul>";
				request.setAttribute("account", account);
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("account/index.jsp").forward(request, response);
			} else {
				request.setAttribute("account", account);
				request.getRequestDispatcher("account/success.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("errors", e.getMessage());
			request.getRequestDispatcher("account/index.jsp").forward(request, response);
		}

	}

}