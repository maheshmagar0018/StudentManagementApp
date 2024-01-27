package com.example.demo.service;

import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
//	@Autowired
//    private JwtTokenProvider jwtTokenProvider;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		var authourities = authentication.getAuthorities();
		var roles = authourities.stream().map(r -> r.getAuthority()).findFirst();
		
		if (roles.orElse("").equals("ADMIN")) {
			response.sendRedirect("/admin-page");
		} else if (roles.orElse("").equals("USER")) {
			response.sendRedirect("/user-page");
		} else {
			response.sendRedirect("/error");
		}
			
	}
		
//		var authourities = authentication.getAuthorities();
//        var roles = authourities.stream().map(GrantedAuthority::getAuthority).findFirst();
//
//        if (roles.orElse("").equals("ADMIN")) {
//            response.sendRedirect("/admin-page");
//        } else if (roles.orElse("").equals("USER")) {
//            String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
//            response.addHeader("Authorization", "Bearer " + token);
//            response.sendRedirect("/user-page");
//        } else {
//            response.sendRedirect("/error");
//        }
		
		
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
//
//        for (GrantedAuthority authority : authorities) {
//            if (authority.getAuthority().equals("ADMIN")) {
//                response.addHeader("Admin-Authorization", "Bearer " + token);
//                response.sendRedirect("/admin-page");
//                return;
//            } else if (authority.getAuthority().equals("USER")) {
//                response.addHeader("User-Authorization", "Bearer " + token);
//                response.sendRedirect("/user-page");
//                return;
//            }
//        }
//
//        // Redirect to an error page if the role is not ADMIN or USER
//        response.sendRedirect("/error");
		
}