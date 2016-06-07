import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/counter")
public class Counter extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("Count: "+(++counter));
		out.println("</BODY>");
		out.println("</HTML>");

	}
	
	int counter = 0;
}
