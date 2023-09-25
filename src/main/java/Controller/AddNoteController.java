package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Service.CategoryService;
import Service.CategoryServiceImpl;
import Model.CategoryModel;
import Model.NoteModel;
import Model.UserProfileModel;
import Service.NoteServiceImpl;
import Service.NoteService;

@WebServlet("/AddNote")
public class AddNoteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserProfileModel up=(UserProfileModel)session.getAttribute("uid");
		CategoryService catService=new CategoryServiceImpl();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("Navbar.html");
		r.include(request, response);
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		    out.println("<div class='import-nav'></div>");
		    out.println("<form method='post' name='frm' action=''>");
		    out.println("<div class='container mt-5'>");
		        out.println("<div class='mb-3'>");
		            out.println("<label for='' class='form-label'>Category</label>");
		           out.println(" <select class='form-select' name='op' aria-label='Default select example'>");
		                List<CategoryModel>list=catService.getAllCategories(up);
		                for(CategoryModel catModel:list)
		                {
		                	 out.println("<option value="+catModel.getCategoryId()+">"+catModel.getCategoryTitle()+"</option>");
		                }
		            out.println("</select>");
		       out.println(" </div>");
		       out.println(" <div class='mb-3'>");
		            out.println("<label for='exampleFormControlTextarea1' class='form-label'>Note Title</label>");
		            out.println("<input type='text' class='form-control' name='title' id='' placeholder=''>");
		        out.println("</div>");
		        out.println("<div class='mb-3'>");
		           out.println(" <label for='exampleFormControlTextarea1' class='form-label'>Description</label>");
		           out.println(" <textarea class='form-control' id='exampleFormControlTextarea1' name='desc' rows='3'></textarea>");
		           out.println("<input type='submit' value='Add+' class='re-btn mt-3'>");
		        out.println("</div>");    
		    out.println("</div>");
		    out.println("</form>");
		out.println("</body>");
		out.println("</html>");

   int cid=Integer.parseInt(request.getParameter("op"));
   out.println(""+cid);
   int id=up.getUid();
   String ntitle=request.getParameter("title").trim();
   String desc=request.getParameter("desc");
   
   Date date=new Date();   
   NoteModel nModel=new NoteModel();
   nModel.setCid(cid);
   nModel.setDate(date);
   nModel.setDesc(desc);
   nModel.setNtitle(ntitle);
   nModel.setUid(id);
   
   
   NoteService nServ=new NoteServiceImpl();
   boolean b=nServ.isAddNote(nModel);
   if(b)
   {
	   out.println("<script>alert('Note Added')</script>");
	    r=request.getRequestDispatcher("Home.html");
	    r.forward(request, response);
   }
   else
   {
	   out.println("<script type='text/javascript'>alert('Unable to add')</script>");
	   out.println("<h1>unable to add</h1>");
   }
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
