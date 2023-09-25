package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.CategoryModel;
import Model.UserProfileModel;
import Service.CategoryService;
import Service.CategoryServiceImpl;

/**
 * Servlet implementation class ShowAllCategoriesController
 */
@WebServlet("/ShowCate")
public class ShowAllCategoriesController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		UserProfileModel up=(UserProfileModel)session.getAttribute("uid");
		CategoryService catService=new CategoryServiceImpl();
		List<CategoryModel>list=catService.getAllCategories(up);
		RequestDispatcher r=request.getRequestDispatcher("Navbar.html");
		r.include(request, response);
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='CSS/style.css' >");
		out.println("<script src='JS/searchCat.js' type='text/javascript'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("<input onkeyup=searchCategory(this.value) type='text' name='sbox' class='mt-5 form-control' value=''  placeholder='Search Category'/>");
		out.println("</div>");
		out.println("<div id='d' class='container' >");
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
		      out.println("<th scope='row'>"+catModel.getCategoryTitle()+"</th>");
		      out.println("<td><a href='UpdateCat?categoryId="+catModel.getCategoryId()+"&catTitle="+catModel.getCategoryTitle()+"  '>Update</a></td>");
		      out.println("<td><a href='DeleteCat?categoryId="+catModel.getCategoryId()+"'>Delete</td>");
		    out.println("</tr>");
		}
		 out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
