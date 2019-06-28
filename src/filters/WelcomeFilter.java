package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "WelcomeFilter", urlPatterns = { "/welcome" })
public class WelcomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        long beforeInvoking = System.currentTimeMillis();

        filterChain.doFilter(servletRequest,servletResponse);

        long afterInvoking = System.currentTimeMillis();

        out.println("Invoking WelcomeServlet takes " + (afterInvoking - beforeInvoking) + " milisseconds");
        out.close();
    }

    @Override
    public void destroy() {

    }
}
