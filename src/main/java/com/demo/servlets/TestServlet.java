package com.demo.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.demo.util.ConnectionPool;
import com.demo.util.DBUtil;

public class TestServlet extends HttpServlet {
	
	/*
	 * private DataSource dataSource; private Connection connection; private
	 * Statement statement;
	 */
	
	  ConnectionPool pool;
	  Connection connection;
	  private Statement statement;
	  ResultSet resultSet;
	
	public void init() throws ServletException {
		/*
		 * try { // Get DataSource Context initContext = new InitialContext(); Context
		 * envContext = (Context)initContext.lookup("java:"); dataSource =
		 * (DataSource)envContext.lookup("Hades"); System.out.println("DATA SOURCE "+
		 * dataSource);
		 * 
		 * 
		 * } catch (NamingException e) { e.printStackTrace(); }
		 */
		pool = ConnectionPool.getInstance();
	    connection = pool.getConnection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 resultSet = null;
		try {
			// Get Connection and Statement
			//	connection = dataSource.getConnection();
				statement = connection.createStatement();
				String query = "SELECT * FROM host";
				resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1) +" "+ resultSet.getString(2) );
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			/*
			 * try { if(null!=resultSet)resultSet.close();} catch (SQLException e)
			 * {e.printStackTrace();} try { if(null!=statement)statement.close();} catch
			 * (SQLException e) {e.printStackTrace();} try {
			 * if(null!=connection)connection.close();} catch (SQLException e)
			 * {e.printStackTrace();}
			 */
			
			DBUtil.closeResultSet(resultSet);
			DBUtil.closeStatment(statement);
			
			pool.freeConnection(connection);
		}
	}
}