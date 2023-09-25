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
import Service.NoteService;
import Service.NoteServiceImpl;
import Model.NoteModel;
import Model.UserProfileModel;
import Service.CategoryService;
import Service.CategoryServiceImpl;
/**
 * Servlet implementation class ShowAllNotes
 */
@WebServlet("/ShowAllNotes")
public class ShowAllNotes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' ref='CSS/style.css'>" );
		out.println("</head>");
		RequestDispatcher r=request.getRequestDispatcher("Navbar.html");
		r.include(request, response);
		out.println("<body>");
		HttpSession session=request.getSession();
		UserProfileModel up=(UserProfileModel)session.getAttribute("uid");
		
		CategoryService catModel=new CategoryServiceImpl();
		
		
		
		
		NoteService noteService=new NoteServiceImpl();
		List<NoteModel>list=noteService.getAllNotes(up.getUid());
		if(list!=null)
		{
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
//		        out.println("<label for='exampleFormControlTextarea1' class='form-label'>Note Title</label>");
		        out.println("<input type='text' class='form-control' value='Last Modified:&nbsp;"+n.getDate()+"' id='' placeholder='' disabled>");
		    out.println("</div>");
			    out.println("<div class='mb-3'>");
			        out.println("<a href='UpateNote?nid="+n.getNid()+"&ntitle="+n.getNtitle()+"&desc="+n.getDesc()+"&date="+n.getDate()+" '><input type='button' value='Update' class='show-btn-1'></a>");
			        out.println("<a href='DeleteNote?nid="+n.getNid()+"'><input type='submit' value='Delete' class='show-btn-2'></a>");
			    out.println("</div>");
			out.println("</div>");
		}
		}
			else
			{
				System.out.println("No record found");
			}
		
		
		
	
	out.println("</body>");
	out.println("</html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
