package com.hoteats.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.security.model.Account;
import com.hoteats.security.repository.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountRepository repository;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Account addAccount(@RequestBody @Valid Account account) {
		return this.repository.save(account);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<String> accounts() {
		return this.repository.findAll().stream().map(Account::getUsername).collect(Collectors.toList());
	}

	@RequestMapping(value = "/echo/{username}", method = RequestMethod.GET)
	public String echo(@PathVariable String username) {
		Account account = this.repository.findByUsername(username);
		if (account == null)
			return username + " not a registered username";
		else
			return "Hello, " + (account.getFname() == null ? account.getUsername() : account.getFname()) + "!";
	}

}
