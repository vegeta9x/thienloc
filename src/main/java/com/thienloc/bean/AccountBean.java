package com.thienloc.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thienloc.mapper.AccountsMapper;
import com.thienloc.model.Accounts;
import com.thienloc.model.AccountsExample;

@Transactional
@Repository
public class AccountBean {
	
	@Autowired
	AccountsMapper accountMapper;
	
	public List<Accounts> totalAccount() {
		AccountsExample accountExample = new AccountsExample();
		
		return accountMapper.selectByExample(accountExample);
	}
	
	public Accounts findAccountByUsername(String username) {
		AccountsExample accountsExample = new AccountsExample();
		accountsExample.createCriteria().andUserNameEqualTo(username);
		
		List<Accounts> accounts = accountMapper.selectByExample(accountsExample);
		
		return accounts.size() > 0 ? accounts.get(0) : null;
	}
	
}
