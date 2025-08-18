package com.Saat.Service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Saat.Config.JwtTokenUtil;
import com.Saat.Entity.User;
import com.Saat.Repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public String login(String email, String rawPassword) throws Exception {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Kullanıcı bulunamadı"));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new Exception("Şifre yanlış");
        }

        
        return jwtTokenUtil.generateToken(user.getEmail());
        
        
    }
	

}
