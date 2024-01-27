//package com.example.demo.jwt;
//
//import java.io.IOException;
//import java.io.Serial;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//	
//	@Serial
//	private static final long serialVersionUID = -8970718410437077606L;
//
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//		
//		
//		
//	}
//
//}
