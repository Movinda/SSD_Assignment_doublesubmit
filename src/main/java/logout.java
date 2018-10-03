import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet implementation class
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private logout(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")){
                    loginCookie = cookie;
                    break;
                }
            }
        }
        if(loginCookie != null){
            loginCookie.setMaxAge(0);
            resp.addCookie(loginCookie);
        }
        HttpSession session = req.getSession();


        session.setAttribute("csrfToken",null);
        resp.sendRedirect("login.jsp");

			/* HttpSession session = request.getSession(false);
			if(session != null)
			    session.invalidate();
			request.getRequestDispatcher("login.jsp").forward(request,response); */

    }
}

