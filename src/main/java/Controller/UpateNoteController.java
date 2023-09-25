package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import Model.NoteModel;
import Service.NoteService;
import Service.NoteServiceImpl;
/**
 * Servlet implementation class UpateNoteController
 */
@WebServlet("/UpateNote")
public class UpateNoteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		NoteModel nModel=new NoteModel();
		
		int nid=Integer.parseInt(request.getParameter("nid"));
		String ctitle=request.getParameter("ntitle");
		String desc=request.getParameter("desc");
		
	    out.println("<html>");
	    out.println("<head>");
	    out.println("</head>");
	    out.println("<body>");
	    RequestDispatcher r=request.getRequestDispatcher("Navbar.html");
	    r.include(request, response);
	    out.println("<form method='post' action=''>");
	    out.println("<div class='container set-shadow mt-5'>");
	         out.println("<div class='mb-3'>");
                  out.println("<input type='hidden' value='"+nid+"' name='noteid' class='form-control' id='' placeholder=''>");
             out.println("</div>");
             out.println(" <div class='mb-3'>");
          		out.println("<label for='exampleFormControlTextarea1' class='form-label'>Note Title</label>");
       		    out.println("<input type='text' class='form-control' name='title' value='"+ctitle+"' id='' placeholder='' >");
             out.println("</div>");
             out.println("<div class='mb-3'>");
       	     	out.println("<label for='exampleFormControlTextarea1' class='form-label'>Description</label>");
       		    out.println("<textarea value='' class='form-control' name='descrip' id='exampleFormControlTextarea1' rows='7'>"+desc+"</textarea>");
             out.println("</div>");
             out.println("<div class='mb-3'>");
                out.println("<input type='submit' value='Update' class='re-btn'>");
             out.println("</div>");
       out.println("</div>");
        out.println("</form>");
	    out.println("</body>");
	    out.println("</html>");
	    
	    int id=Integer.parseInt(request.getParameter("noteid"));
	    String title=request.getParameter("title");
	    String desc1=request.getParameter("descrip");
	    Date date1=new Date();
	    
	    nModel.setNid(id);
	    nModel.setNtitle(title);
	    nModel.setDesc(desc1);
	    nModel.setDate(date1);
	    
	    NoteService nService=new NoteServiceImpl();
	    boolean b=nService.updateNote(nModel);
	    if(b)
	    {
	    	out.println("<script>alert('Note Updated Successfully')</script>");
	    	r=request.getRequestDispatcher("ShowAllNotes");
	    	r.forward(request, response);
	    }
	    else
	    {
	    	out.println("<script>alert('Note Not Updated')</script>");
	    }
	    
	    
	}

	private Date Date(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
