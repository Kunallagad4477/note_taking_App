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
import Model.NoteModel;
import Model.UserProfileModel;
import Service.CategoryService;
import Service.CategoryServiceImpl;
import Service.NoteService;
import Service.NoteServiceImpl;

/**
 * Servlet implementation class ShowCategoryWiseNotes
 */
@WebServlet("/ShowCategoryWise")
public class ShowCategoryWiseNotes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		UserProfileModel up=(UserProfileModel)session.getAttribute("uid");
		int userId=up.getUid();
		CategoryService catService=new CategoryServiceImpl();
		NoteService noteService=new NoteServiceImpl();
		List<NoteModel>list=noteService.getAllNotes(up.getUid());
		out.println("<htm>");
		out.println("<head>");
		out.println("<script src='JS/searchCat.js' type='text/javascript'></script>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("Navbar.html");
		r.include(request, response);
		 out.println("<div class='container mt-5'>");
	        out.println("<div class='mb-3'>");
	            out.println("<label for='' class='form-label'>Category</label>");
	           out.println(" <select onchange='searchNotes(this.value,"+userId+")'class='form-select' name='op' id='op' aria-label='Default select example' >");
	                List<CategoryModel>list1=catService.getAllCategories(up);
	                for(CategoryModel catModel1:list1)
	                {
	                	 out.println("<option value="+catModel1.getCategoryId()+">"+catModel1.getCategoryTitle()+"</option>");
	                }
	            out.println("</select>");
	       out.println(" </div>");
	       out.println("<div class='container mt-2' id='s'>");
	       out.println("</div>");
	      out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
