package com.Saat.Controller;

import java.util.List;

import com.Saat.Dto.DtoUser;
import com.Saat.Entity.User;

public interface IUserController {
	public DtoUser saveuser(User newuser);
	public List<DtoUser> findByuserid(String name);

}
