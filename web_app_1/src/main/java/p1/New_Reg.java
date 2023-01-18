package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/new")
public class New_Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public New_Reg() {
        super();
 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	 String name = request.getParameter("name");
	 String city = request.getParameter("city");
	 String email = request.getParameter("email");
	 String mobile = request.getParameter("mobile");
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");//("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app_demo","root","test"); 
		  try (Statement stmnt = con.createStatement()) {
			  stmnt.executeUpdate("insert into student values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			  con.close();
			
		};
	  }catch (Exception e){
		e.printStackTrace();   
	  }

	}
	

}
