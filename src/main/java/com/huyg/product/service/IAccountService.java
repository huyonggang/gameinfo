package com.huyg.product.service;

import com.huyg.product.entity.Account;

import java.util.List;

public interface IAccountService {


    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();


    int addByMapper(Account account);

    int updateByMapper(Account account);

    int deleteByMapper(int id);

    Account findAccountByIdByMapper(int id);

    List<Account> findAccountListByMapper();
}
