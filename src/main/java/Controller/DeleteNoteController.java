package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.NoteService;
import Service.NoteServiceImpl;
/**
 * Servlet implementation class DeleteNoteController
 */
@WebServlet(name = "DeleteNote", urlPatterns = { "/DeleteNote" })
public class DeleteNoteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int nid=Integer.parseInt(request.getParameter("nid").trim());
		NoteService nServ=new NoteServiceImpl();
		boolean b=nServ.isDeleteNote(nid);
		if(b)
		{
			out.println("<script>alert('note deleted');</script>");
			RequestDispatcher r=request.getRequestDispatcher("ShowAllNotes");
			r.forward(request, response);
		}
		else
		{
			out.println("<script>alert('Unable to deleted the note')</script>");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
