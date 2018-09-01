package com.pmv.service;

import java.util.List;

import com.pmv.entity.Role;

public interface RoleService {
	
	public abstract List<Role> getAll();
	
	public abstract Role getOne(int roleId);
	
	public abstract Role addOne(Role role);
	
	public abstract void delete(int roleId);
	
	public abstract Role getByNameRole(String role);

}
