package com.xafdy.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//    String uri = request.getRequestURI();
//    if (uri.contains("clothes") || uri.contains("hotel") ||uri.contains("food") ||uri.contains("goods") ||uri.contains("control") || uri.endsWith("logout.html") || uri.endsWith("userLogon.html") || uri.endsWith("/index.html") || uri.endsWith("logon.html") ||  uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".jpg") || uri.endsWith(".png")) {
    	filterChain.doFilter(request, response);
//    } else {
//    	if (request.getSession().getAttribute("user") != null) {
//    		filterChain.doFilter(request, response);
//    	} else {
//    		PrintWriter pw = response.getWriter();
//    		pw.print("<script>location.href='/travel/logon.html'</script>");
//    		pw.close();
//    	}
//    }
  }
}
