package com.Saat.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Saat.Dto.DtoUser;
import com.Saat.Entity.User;
import com.Saat.Repository.UserRepository;

@Service
public class UserServiceimpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	
	private final PasswordEncoder passwordEncoder;
	
	 public UserServiceimpl(@Lazy PasswordEncoder passwordEncoder) {
	        this.passwordEncoder = passwordEncoder;
	    }

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
		System.out.println("DB'de aranıyor (IgnoreCase): " + email);

	    Optional<User> userOpt = userRepository.findByEmailIgnoreCase(email.trim());

	    if(userOpt.isPresent()) {
	        User user = userOpt.get();

	        System.out.println("Kullanıcı bulundu: " + user.getEmail());

	        return user;
	    } else {
	        throw new RuntimeException("kullanıcı bulunamadi");
	    }
	}

	@Override
	public User getuser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
	        throw new RuntimeException("Lütfen giriş yapınız.");
	    }
	    String email;
	    Object principal = auth.getPrincipal();
	    if (principal instanceof UserDetails) {
	        email = ((UserDetails) principal).getUsername();
	    } else if (principal instanceof User) {
	        email = ((User) principal).getEmail();
	    } else {
	        throw new RuntimeException("Bilinmeyen principal tipi");
	    }
	    
	    User user=getUserbyEmail(email);

		return user;
	}
	}

	
	
	


