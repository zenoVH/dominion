
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import gameEngine.*;

/**
 * Servlet implementation class DominionServlet
 */
public class DominionServlet extends HttpServlet {
	
	private GameEngine engine = new GameEngine();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DominionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		engine.init(2);
		engine.getPlayer().setName("Arnaud");
		String text = engine.getPlayer().getName();

	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(text);
	}
		
}
