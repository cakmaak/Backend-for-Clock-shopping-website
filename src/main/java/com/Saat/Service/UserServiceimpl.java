package com.Saat.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoUser;
import com.Saat.Entity.User;
import com.Saat.Repository.UserRepository;

@Service
public class UserServiceimpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<DtoUser> findByuserid(String name) {
		
		List<User> userlist=new ArrayList<>();
		return null;
		
	}

	@Override
	public DtoUser saveuser(User newuser) {
		User user = new User();
		BeanUtils.copyProperties(newuser, user);
		
		user.setPassword(passwordEncoder.encode(newuser.getPassword()));
		userRepository.save(user);
		
	
		
		DtoUser dtoUser=new DtoUser();
		
		BeanUtils.copyProperties(user, dtoUser);
		
		
		
		return dtoUser;
	}
	@Override
	public User getUserbyEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(()->  new RuntimeException("kullanıcı bulunamadi"));
		
		
	}

	
	
	

}
