package com.hoteats.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hoteats.security.model.Account;
import com.hoteats.security.repository.AccountRepository;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private AccountRepository repository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Account account = repository.findByUsername(username);
				if (account == null)
					account = new Account(1L, "admin", "admin");
				return new User(account.getUsername(), account.getPassword(), true, true, true, true,
						AuthorityUtils.createAuthorityList("USER"));
			}
		};
	}

}
