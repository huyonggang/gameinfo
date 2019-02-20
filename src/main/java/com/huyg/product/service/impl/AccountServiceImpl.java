package com.huyg.product.service.impl;

import com.huyg.product.dao.IAccountDAO;
import com.huyg.product.entity.Account;
import com.huyg.product.mapper.AccountMapper;
import com.huyg.product.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDAO accountDAO;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }

    @Override
    public int addByMapper(Account account) {
        return accountMapper.add(account.getName(), account.getMoney());
    }

    @Override
    public int updateByMapper(Account account) {
        return accountMapper.update(account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public int deleteByMapper(int id) {
        return accountMapper.delete(id);
    }

    @Override
    public Account findAccountByIdByMapper(int id) {
        return accountMapper.findAccount(id);
    }

    @Override
    public List<Account> findAccountListByMapper() {
        return accountMapper.findAccountList();
    }
}
