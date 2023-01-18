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

 
@WebServlet("/update")
public class Update_Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Update_Reg() {
        super();
 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	 String email = request.getParameter("email");
	 String mobile = request.getParameter("mobile");
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");//("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app_demo","root","test"); 
		  try (Statement stmnt = con.createStatement()) {
			  stmnt.executeUpdate("update student set mobile='"+mobile+"' where email = '"+email+"'");
			  con.close();
			
		};
	  }catch (Exception e){
		e.printStackTrace();   
	  }

	}
	

}
