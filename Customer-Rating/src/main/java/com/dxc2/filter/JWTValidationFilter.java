package com.dxc2.filter;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTValidationFilter extends GenericFilterBean{

	 

    public static final String BEARER = "Bearer";

    public static final String AUTHORIZATION = "Authorization";

 

    @Override

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)

            throws IOException, ServletException {

    

        HttpServletRequest request = (HttpServletRequest)servletRequest;

        HttpServletResponse response = (HttpServletResponse)servletResponse;

        final String authorization = request.getHeader(AUTHORIZATION);

        if(authorization == null || !authorization.startsWith(BEARER)) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().println("Auth Header is missing");

        }    

    

        else {

            // Bearer tokenValue

            String token = authorization.substring(7);

            

            try {

                final Claims claims = Jwts.parser().setSigningKey("testsecretkey")

                        .parseClaimsJws(token)

                        .getBody();

                request.setAttribute("claims", claims);

                String role=(String) claims.get("role");

                    System.out.println(role);

                    

                String subject =claims.getSubject();

                String[] sellerdetails = subject.split(",");    

                String sellername=sellerdetails[0];

                String selleremail=(sellerdetails[1]);

                    System.out.println(sellername);

                    System.out.println(selleremail);

                chain.doFilter(request, response);

            }

            catch(Exception e) {

                response.setStatus(HttpServletResponse.SC_FORBIDDEN);

                response.getWriter().println("Invalid Token");

            }

            }

            

        }

 

 

}