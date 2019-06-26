package servlets;

import utility.Algorithms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WordCounterServlet", urlPatterns = { "/word" })
public class WordCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("link.html").include(req, resp);

        String text = req.getParameter("text");
        String targetWord = req.getParameter("target");

        int count = Algorithms.getFamiliarStrings(targetWord.toLowerCase(), text.toLowerCase());

        out.println("<br>");
        out.println("your text is ");
        out.println(text);
        out.println("<br>");
        out.println("target word is ");
        out.println(targetWord);
        out.println("<br>");
        out.println("count of words in text is " + count);
    }
}
