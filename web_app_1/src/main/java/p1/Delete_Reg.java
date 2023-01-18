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

 
@WebServlet("/delete")
public class Delete_Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Delete_Reg() {
        super();
 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	 String email = request.getParameter("email"); 
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");//("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app_demo","root","test"); 
		  try (Statement stmnt = con.createStatement()) {
			  stmnt.executeUpdate("delete from student where email = '"+email+"'");
			  con.close();
		};
	  }catch (Exception e){
		e.printStackTrace();   
	  }

	}
	

}
