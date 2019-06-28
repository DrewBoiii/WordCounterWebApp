package servlets;

import utility.Algorithms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", urlPatterns = { "/welcome" })
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        long hash = Algorithms.hash("asdasdadjkasfgaskfjgasjfgaksjfgasdddwqdqwdqwdqwdqdqdqwdqwdqwdaa1237542211");
        out.println("Welcome to the page!");
    }
}
