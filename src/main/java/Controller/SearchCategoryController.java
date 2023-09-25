package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.CategoryService;
import Service.CategoryServiceImpl;
import Model.CategoryModel;
import Model.UserProfileModel;


/**
 * Servlet implementation class SearchCategoryController
 */
@WebServlet("/SearchCat")
public class SearchCategoryController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("catName");
		HttpSession session=request.getSession();
		UserProfileModel up=(UserProfileModel)session.getAttribute("uid");
		CategoryService catService=new CategoryServiceImpl();
		List<CategoryModel>list=catService.getAllCategoriesByName(name,up);
		out.println("<table class='table mt-5' style='text-align:center'; >");
		  out.println("<thead>");
		    out.println("<tr>");
		      out.println("<th scope='col'>Category</th>");
		      out.println("<th scope='col'>Update</th>");
		      out.println("<th scope='col'>Delete</th>");
		    out.println("</tr>");
		  out.println("</thead>");
		  out.println("<tbody>");  
		for(CategoryModel catModel:list) {
			out.println("<tr>");
			out.println("<td>"+catModel.getCategoryTitle()+"</td>");
			out.println("<td><a href=''>Update</a></td>");
			out.println("<td><a href='DeleteCat?categoryId="+catModel.getCategoryId()+"'>Delete</a></td>");
			out.println("</tr>");
			
		}
		    out.println("</tbody>");
			out.println("</table>");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
