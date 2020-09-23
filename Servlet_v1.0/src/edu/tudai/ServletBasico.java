package edu.tudai;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBasico
 */
@WebServlet("/ServletBasico/*")
public class ServletBasico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int visitCounter;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBasico() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	visitCounter = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().
		append("Served at: ").
		append(request.getContextPath()).
		append("\nCantidad de requests: ").append(Integer.toString(++this.visitCounter));
	}

}
