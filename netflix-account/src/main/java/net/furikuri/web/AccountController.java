package net.furikuri.web;

import net.furikuri.domain.Account;
import net.furikuri.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public List<Account> getAll() {
        return accountService.getAll();
    }
}
