package com.huyg.product.controller;

import com.huyg.product.entity.Account;
import com.huyg.product.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Account> getAccounts(){
        return accountService.findAccountListByMapper();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name",required = true) String name,
                                @RequestParam(value = "money",required = true) double money){
        Account account= new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t = accountService.update(account);
        if (t==1) {
            return account.toString();
        }
        return "fail";
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money){
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        int t =accountService.add(account);
        if (t==1){
            return account.toString();
        }
        return "fail";
    }

}
