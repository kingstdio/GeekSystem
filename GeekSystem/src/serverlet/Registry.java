package serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * Servlet implementation class Registry
 */
@WebServlet(description = "注册Servlet", urlPatterns = { "/Registry" })
public class Registry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public User user = new User();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user.setUserName(request.getParameter("userName"));
		//String userName= request.getParameter("userName");
		String password = request.getParameter("password");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br/>").append(user.getUserName()+"-"+password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
