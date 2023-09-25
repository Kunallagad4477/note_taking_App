package Controller;
import java.io.*;
import Service.UserService;
import Service.UserServiceImpl;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserProfileModel;

/**
 * Servlet implementation class UserValidateController
 */
@WebServlet("/ValidateUser")
public class UserValidateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserProfileModel UserModel=new UserProfileModel();
		UserModel.setEmail(email);
		UserModel.setPassword(password);
		try {
			UserService userService=new UserServiceImpl();
			UserProfileModel model=userService.validateUser(UserModel);
			if(model!=null)
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("uid", model);	
				RequestDispatcher r=request.getRequestDispatcher("Home.html");
				r.forward(request, response);
			}
			else
			{
				out.println("<h1>Invalid username and Password</h1>");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
