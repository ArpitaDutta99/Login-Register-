package com.company.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.company.dao.UserDaoImp;

import com.company.dao.*;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UserDao userDao = new UserDaoImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");  //Check valid username into the server...
		String password = request.getParameter("password");  // Check valid password of the username into the server...
		
		if(userDao.isValidUser(username,password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username",username);   // if user name and password validated the redirect to welcome page...
			response.sendRedirect("welcome.jsp");
			
		}else {
			response.sendRedirect("login.jsp?error=1");   // if not validation failed the show error...
			System.out.println("Error!!");
		}
	}

}
