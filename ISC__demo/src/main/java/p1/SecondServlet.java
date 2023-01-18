package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SecondServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name =(String)request.getAttribute("name");
		System.out.println(name);
		
		// Extract data using session variable or extract session variable value
		
		HttpSession session = request.getSession();
		String sessionName = (String)session.getAttribute("sessionName");
		System.out.println(sessionName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String name =(String)request.getAttribute("name");
		System.out.println(name);
		
		// Extract data using session variable or extract session variable value
		
		HttpSession session = request.getSession();
		String sessionName = (String)session.getAttribute("sessionName");
		System.out.println(sessionName);
	
		
	}

}
