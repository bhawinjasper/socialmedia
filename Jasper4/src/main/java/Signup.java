

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String unamer=request.getParameter("uname");
		 String phnr=request.getParameter("phno");
		 String psr=request.getParameter("pass");
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jaspermedia","root","123456789");
			 PreparedStatement ps=con.prepareStatement("insert into useraccount(UNAME,PHNO,PASSWORD) values(?,?,?);");
			 ps.setString(1, unamer);
			 ps.setString(2, phnr);
			 ps.setString(3, psr);
			 
			 System.out.println(ps.executeUpdate());
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
