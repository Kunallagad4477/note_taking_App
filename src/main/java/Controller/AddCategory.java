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
import model.AdminProfileModel;
@WebServlet("/addCat")
public class AddCategory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String CTitle=request.getParameter("cname");
		HttpSession session=request.getSession();
		CategoryService catServ=new CategoryServiceImpl();
		UserProfileModel up=(UserProfileModel)session.getAttribute("uid");
		List<CategoryModel>list=catServ.getAllCategories(up);
		if(list==null)
		{
			CategoryModel CatModel=new CategoryModel();
    		CatModel.setCategoryTitle(CTitle);
    		CategoryService cservice=new CategoryServiceImpl();
    	    boolean b=cservice.isAddCategory(CatModel,up);
    	    if(b)
    	    {
    	    	out.println("<script>alert('Added')</script>");
    	    	RequestDispatcher r=request.getRequestDispatcher("Home.html");
    	    	r.include(request, response);
    	    }
    	    else
    	    {
    	    	out.println("<script>alert('Unable To Add')</script>");
    	    	RequestDispatcher r=request.getRequestDispatcher("addCategory.html");
    	    	r.include(request, response);
    	    
    	    }
		}
		else
		{
			int flag=0;
			
			for(CategoryModel catModel:list)
	        {
	        	if(catModel.getCategoryTitle().equalsIgnoreCase(CTitle))
	        	{
	        		flag=1;
	        		break;
	        	}
	 
	        }
			
		
		
			if(flag==0)
	        {
	        	CategoryModel CatModel=new CategoryModel();
	    		CatModel.setCategoryTitle(CTitle);
	    		CategoryService cservice=new CategoryServiceImpl();
	    	    boolean b=cservice.isAddCategory(CatModel,up);
	    	    if(b)
	    	    {
	    	    	out.println("<script>alert('Added')</script>");
	    	    	RequestDispatcher r=request.getRequestDispatcher("Home.html");
	    	    	r.include(request, response);
	    	    }
	    	    else
	    	    {
	    	    	out.println("<script>alert('Unable To Add')</script>");
	    	    	RequestDispatcher r=request.getRequestDispatcher("addCategory.html");
	    	    	r.include(request, response);
	    	    
	    	    }
	        }
	        else
	        {
	        	out.println("<script>alert('Category already present')</script>");
		    	RequestDispatcher r=request.getRequestDispatcher("addCategory.html");
		    	r.include(request, response);
	        }
		}
		
			
		}
		
        

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
