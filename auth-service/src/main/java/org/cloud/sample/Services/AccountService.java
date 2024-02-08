package org.cloud.sample.Services;

import org.cloud.sample.AOP.PageHelper.Page;
import org.cloud.sample.AOP.PageHelper.Pageable;
import org.cloud.sample.Dao.AccountMapper;
import org.cloud.sample.Entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    private final AccountMapper accountMapper;
    @Autowired
    public AccountService(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }
    @Transactional
    public void createAccount(Account account){
        this.accountMapper.createAccount(account);
    }
    public boolean email_pass_match(String email, String password){
        return this.accountMapper.findByEmailAndPass(email, password).isPresent();
    }
    @Pageable
    public List<Account> getAllAccount(Page page){
        return this.accountMapper.findAll(page.getStart(), page.getOffset());
    }
}
