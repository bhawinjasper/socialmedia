

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String unamer=request.getParameter("uname");
		 String psr=request.getParameter("pass");
		 System.out.println(unamer);
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jaspermedia","root","123456789");
			 PreparedStatement ps=con.prepareStatement("Select PASSWORD from useraccount where UNAME=?");
			 ps.setString(1, unamer);
			 ResultSet rs=ps.executeQuery();
			  rs.next();
			    response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			    if(rs.getString("PASSWORD").equals(psr)) {
			    	response.getWriter().write("success");
			    }else {
			    	response.getWriter().write("failure");
			    }
			   
			 
			 
			
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
