package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserProfileModel;
import Service.UserService;
import Service.UserServiceImpl;

@WebServlet("/register")
public class registerUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserProfileModel userModel=new UserProfileModel();
		userModel.setName(name);
		userModel.setEmail(email);
		userModel.setPassword(password);
		
			UserService uservice=new UserServiceImpl();
			boolean b=uservice.isRegister(userModel);
			if(b)
			{
				RequestDispatcher r=request.getRequestDispatcher("login.html");
				r.forward(request, response);
			}
			else
			{
				out.println("<h1>Error in registration</h1>");
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
