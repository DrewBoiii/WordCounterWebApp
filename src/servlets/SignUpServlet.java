package servlets;

import dao.SignUpDAO;
import data.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet", urlPatterns = { "/signup" })
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String nickname = req.getParameter("userNickname");
        String password = req.getParameter("userPassword");
        User user = new User(nickname, password);

        int status = SignUpDAO.saveUser(user);

        if(status > 0){
            out.println("<h1>Record into database was successful</h1>");
            req.getRequestDispatcher("index.html").include(req, resp);
        } else {
            out.println("<h1>Something gone wrong</h1>");
        }
    }
}
