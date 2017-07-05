package serverlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.userOperation;
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
		
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		userOperation userOp = new userOperation();
		
		ResultSet rs = userOp.getUserList();
		
		try {
			response.getWriter().append("<table width='100%'>");
			response.getWriter().append("<tr><td>编号</td><td>用户名</td><td>密码</td><td>Email</td></tr>");
			while(rs.next()) {
				
				
				response.getWriter().append("<br/><tr><td>").append(String.valueOf( rs.getInt(1))+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)
						+"</td><td>"+rs.getString(4)+"</td></tr>");	
				
			}
			response.getWriter().append("</table>");
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		if(userOp.userIsExists(user)) {
			response.getWriter().append("<br/>").append(user.getUserName()+"已经存在");
			return;
		}
		
	   try {
		if(	userOp.userAdd(user)) {
			   response.getWriter().append("<br/>").append(user.getUserName()+"注册成功");
		   }
		else {
			response.getWriter().append("<br/>").append(user.getUserName()+"注册失败");
		}
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
		
	   response.getWriter().append("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
