package Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateCategoryController
 */
@WebServlet("/UpdateCat")
public class UpdateCategoryController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		UserProfileModel up=(UserProfileModel)session.getAttribute("uid");
		int Userid=up.getUid();
		int catid=Integer.parseInt(request.getParameter("categoryId").trim());
		String catTitle=request.getParameter("catTitle");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher r=request.getRequestDispatcher("Navbar.html");
		r.include(request,response);
		    out.println("<form method='post' name='frm' action=''>");
		    out.println("<div class='container mt-5'>");
		    out.println("<div class='form-group mb-3'>");
	           out.println ("<input type='hidden' class='form-control' name='cid' value='"+catid+"' required>");
	        out.println("</div>");
		        out.println("<div class='form-group mb-3'>");
		           out.println ("<label  class='form-label'>Category Title</label>");
		           out.println ("<input type='text' class='form-control' name='catname' value='"+catTitle+"' required>");
		        out.println("</div>");
		        out.println("<div class='mb-3'>");
		            out.println("<input type='submit' value='Update' class='re-btn'>");
		        out.println("</div> ");
		   out.println ("</div>");
		 out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		String cTitle=request.getParameter("catname");
		int cid=Integer.parseInt(request.getParameter("cid"));
		CategoryService catServ=new CategoryServiceImpl();
		CategoryModel CatModel=new CategoryModel();
		CatModel.setCategoryId(cid);
		CatModel.setCategoryTitle(cTitle);
		
		boolean b=catServ.UpdateCategory(CatModel,Userid);
		if(b)
		{
			out.println("<script>alert('Category Updated Successfully')</script>");
			 r=request.getRequestDispatcher("ShowCate");
			 r.forward(request, response);
		}
		else
		{
			out.println("<script>alert('Category Not Updated')</script>");
			System.out.println("Unable to update category");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
