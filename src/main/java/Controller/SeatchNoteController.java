package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.NoteServiceImpl;
import Service.CategoryService;
import Service.CategoryServiceImpl;
import Service.NoteService;
import Model.CategoryModel;
import Model.NoteModel;

/**
 * Servlet implementation class SeatchNoteController
 */
@WebServlet("/SearchNote")
public class SeatchNoteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int cid=Integer.parseInt(request.getParameter("cid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		CategoryService catModel=new CategoryServiceImpl();
		NoteService nServ=new NoteServiceImpl();
		List<NoteModel>list=nServ.getAllNotesByCategory(cid,uid);
		if(list!=null)
		
		{
			out.println("<div class='container'>");
			for(NoteModel n:list)
			{
			 out.println("<div class='container mt-5 set-shadow' >");
				out.println("<div class='mb-3'>");
		        out.println("<label for='' class='form-label'>Category</label>");
		          String cTitle=catModel.getCategoryName(n.getCid());
		          out.println("<input type='text' value='"+cTitle+"' class='form-control' id='' placeholder='' disabled>");
		        out.println("</div>");
		   out.println(" <div class='mb-3'>");
		        out.println("<label for='exampleFormControlTextarea1' class='form-label'>Note Title</label>");
		        out.println("<input type='text' class='form-control' value='"+n.getNtitle()+"' id='' placeholder='' disabled>");
		    out.println("</div>");
		    out.println("<div class='mb-3'>");
		        out.println("<label for='exampleFormControlTextarea1' class='form-label'>Description</label>");
		        out.println("<textarea value='"+n.getDesc()+"' class='form-control' id='exampleFormControlTextarea1' rows='7' disabled>"+n.getDesc()+"</textarea>");
		    out.println("</div>");
		    out.println(" <div class='mb-3'>");
//	        out.println("<label for='exampleFormControlTextarea1' class='form-label'>Note Title</label>");
	            out.println("<input type='text' class='form-control' value='Last Modified:&nbsp;"+n.getDate()+"' id='' placeholder='' disabled>");
	        out.println("</div>");
		    out.println("<div class='mb-3'>");
		        out.println("<a href='UpateNote?nid="+n.getNid()+"&ntitle="+n.getNtitle()+"&desc="+n.getDesc()+"&date="+n.getDate()+" '><input type='button' value='Update' class='show-btn-1'></a>");
		        out.println("<a href='DeleteNote?nid="+n.getNid()+"'><input type='submit' value='Delete' class='show-btn-2'></a>");
		    out.println("</div>");
			out.println("</div>");
			}
		
		 out.println("</div>");
		}
		else
		{
			out.println("<div class='container mt-5 set-shadow'>");
			 out.println(" <div class='mb-3'>");
		        out.println("<input type='text' class='form-control' value='No Any Note Belong to perticular category' id='' placeholder='' disabled>");
		    out.println("</div>");
		    out.println("</div>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
