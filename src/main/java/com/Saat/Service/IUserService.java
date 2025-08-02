package com.Saat.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.Saat.Dto.DtoUser;
import com.Saat.Entity.RegisterRequest;
import com.Saat.Entity.User;


public interface IUserService {
public List<DtoUser> findByuserid(String name);
public DtoUser saveuser(User newuser);
public User getUserbyEmail(String email);

}
