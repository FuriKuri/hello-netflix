package net.furikuri.web;

import net.furikuri.clients.Account;
import net.furikuri.clients.AccountClient;
import net.furikuri.clients.Product;
import net.furikuri.clients.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountClient accountClient;

    @Autowired
    @Qualifier("net.furikuri.clients.ProductClient")
    private ProductClient productClient;

    @RequestMapping("/account")
    public Account get() {
        return accountClient.findAllAccounts().get(0);
    }

    @RequestMapping("/product")
    public Product getP() {
        return productClient.findAllProducts().get(0);
    }
}
