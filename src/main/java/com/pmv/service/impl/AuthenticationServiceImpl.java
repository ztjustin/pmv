package com.pmv.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pmv.entity.Role;
import com.pmv.service.UserService;


@Service("authService")
public class AuthenticationServiceImpl implements UserDetailsService{
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(AuthenticationServiceImpl.class);
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		com.pmv.entity.User user = userServiceImpl.getOne(userName);
		if(user!=null)
		{
			Set<Role> roles = new HashSet<Role>();
			roles.add(user.getRole());
			List<GrantedAuthority> authorities = buildAuthorities(roles);
			return buildUser(user, authorities);
		}
		else return  null;
		
		
	}
	
	private User buildUser(com.pmv.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<Role> roles) {
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

		for (Role role : roles) {
			LOG.info("EL ROLES ES:"+role.getName());
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}
		
		LOG.info("EL GrantedAuthority ES:"+auths.toString());

		return new ArrayList<GrantedAuthority>(auths);
	}
	
	
	

}
