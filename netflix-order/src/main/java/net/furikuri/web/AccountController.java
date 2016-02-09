package net.furikuri.web;

import net.furikuri.clients.Account;
import net.furikuri.clients.AccountClient;
import net.furikuri.clients.Product;
import net.furikuri.clients.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountClient accountClient;

    @Autowired
    @Qualifier("net.furikuri.clients.ProductClient")
    private ProductClient productClient;

    @RequestMapping("/account")
    public Account get() {
        logger.info("Got request.");
        return accountClient.findAllAccounts().get(0);
    }

    @RequestMapping("/product")
    public Product getP() {
        logger.info("Got request.");
        return productClient.findAllProducts().get(0);
    }
}
