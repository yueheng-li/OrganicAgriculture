package com.organic.agriculture.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.organic.agriculture.bean.User;

@Component
public class UserService implements UserDetailsService {
//	@Autowired
//	private UserMapper userMapper;

	public UserDetails loadUserByUsername(String eName) {

		User user = new User();
		user.setAccount("123");
		user.setPwd("123");
//		User user = userMapper.findByUserName(eName);
//		if (user == null) {
//			throw new UsernameNotFoundException("ユーザ存在しない");
//		}
//		//
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		// 用于添加用户的权限。只要把用户权限添加到authorities
//		for (Role role : user.getRoles()) {
//			authorities.add(new SimpleGrantedAuthority(role.getRname()));
//		}
//		logger.info("user : " + user.toString());

		return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPwd(), authorities);
	}

}
