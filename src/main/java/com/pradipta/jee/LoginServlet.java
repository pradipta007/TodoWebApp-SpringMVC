package com.pradipta.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// EXAMPLE OF SERVLET
/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		PrintWriter out = response.getWriter();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		request.setAttribute("name",name);
		request.setAttribute("pass",pass);
		
		UserValidation uv = new UserValidation();
		if(uv.isUserValid(name,pass))
		{
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "Invalid credentials");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
		
		PrintWriter out = response.getWriter();
		
	}

}

