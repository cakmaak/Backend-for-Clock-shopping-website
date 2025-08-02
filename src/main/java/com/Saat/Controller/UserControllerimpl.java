package com.Saat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Saat.Dto.DtoLogin;
import com.Saat.Dto.DtoUser;
import com.Saat.Entity.User;
import com.Saat.Service.IUserService;
import com.Saat.Service.AuthService.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/saatciapo/user")
public class UserControllerimpl implements IUserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	AuthService authService;



	@Override
	@PostMapping("/saveuser")
	public DtoUser saveuser(@RequestBody @Valid User newuser) {
		
		return userService.saveuser(newuser);
	}

	@Override
	public List<DtoUser> findByuserid(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody DtoLogin loginRequest) {
	        try {
	            String token = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
	            return ResponseEntity.ok(token);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	        }
	    }
	
	
}
	

	
	
	
	
	


