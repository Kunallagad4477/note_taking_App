package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.CategoryServiceImpl;
import Service.CategoryService;
/**
 * Servlet implementation class DeleteCategoryController
 */
@WebServlet("/DeleteCat")
public class DeleteCategoryController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseUnsignedInt(request.getParameter("categoryId").trim());
		CategoryService catServ=new CategoryServiceImpl();
		boolean result=catServ.deleteCat(id);
		if(result)
		{
			out.println("<script>alert('Category Deleted Successfully')</script>");
			RequestDispatcher r=request.getRequestDispatcher("ShowCate");
			r.forward(request, response);
		}
		else
		{
			out.println("<script>alert('Not Deleted')</script>");
			out.println("<h1>Error in deletion</h1>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
