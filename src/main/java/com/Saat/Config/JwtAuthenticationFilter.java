package com.Saat.Config;

import java.io.IOException;
import java.util.Collections;

import com.Saat.Service.IUserService;
import com.Saat.Config.JwtTokenUtil;
import com.Saat.Entity.User;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	


    private final IUserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    public JwtAuthenticationFilter(@Lazy IUserService userService, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }
    
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        String userEmail = null;
        String jwt = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            try {
                userEmail = jwtTokenUtil.extractUsername(jwt);
                System.out.println("Token'dan çıkarılan email: '" + userEmail + "'");
            } catch (Exception e) {
                System.out.println("Token'dan email çıkarılamadı: " + e.getMessage());
            }
        }

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                User user = userService.getUserbyEmail(userEmail);
                System.out.println("DB'den bulunan kullanıcı email: '" + user.getEmail() + "'");

                UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (RuntimeException e) {
                System.out.println("Kullanıcı bulunamadı: " + userEmail);
                // Burada hata fırlatma yok, sadece logla
            }
        }

        filterChain.doFilter(request, response);
    }
}