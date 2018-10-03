import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.beans.Encoder;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

@WebServlet("/LoginCheck")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // auto generated method
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {

			/*
			 * Random session id generated for successful login
			 * converts to string The id save as a cookie name "user" inside the
			 * browser The cookie valid for 1 hour
			 */
            UUID idOne = UUID.randomUUID();
            String id = idOne.toString();
            Cookie loginCookie = new Cookie("user", id);
            loginCookie.setMaxAge(60 * 60);
            resp.addCookie(loginCookie);

			/* Generates CSRF token and store in server side */
            HttpSession session = req.getSession();

            String storedToken = (String) session.getAttribute("doubleSubCookie");
            System.out.println("storedToken: " + storedToken);
            if (storedToken == null) {

                String doubleCsrfToken = generateCSRFToken();
                Cookie doubleSubCookie = new Cookie("doubleSubCookie", doubleCsrfToken);
                doubleSubCookie.setMaxAge(30*60);
                resp.addCookie(doubleSubCookie);
            }

            resp.sendRedirect("form.jsp");

        } else {
            resp.sendRedirect("error.jsp");
        }

    }

    public static String generateCSRFToken() {
        SecureRandom random = new SecureRandom();

        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        return token;

    }
}
