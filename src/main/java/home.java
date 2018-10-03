import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class home extends HttpServlet {

    public home(){
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // auto generated method
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = req.getParameter("tokenval");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("doubleSubCookie")) {

                    String doubleSubmitCookie = cookie.getValue();
                    System.out.println("doubleSubmitCookie val"
                            + doubleSubmitCookie);

                    if (token.equals(doubleSubmitCookie)) {

                        System.out.println("ok: " + token);
                        PrintWriter out = resp.getWriter();

                        out.print("<script language='JavaScript'>alert('Success');</script>");

                    } else {
                        System.out.println("no token: " + token);
                        PrintWriter out = resp.getWriter();
                        out.print("<script language='JavaScript'>alert('Error');</script>");
                    }

                }
            }
        }
    }
}
