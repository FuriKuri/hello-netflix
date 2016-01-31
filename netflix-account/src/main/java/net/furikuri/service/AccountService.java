package net.furikuri.service;

import com.boundary.config.ConsulWatchedConfigurationSource;
import com.ecwid.consul.v1.ConsulClient;
import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicWatchedConfiguration;
import net.furikuri.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AccountService {
    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    private int delay = 0;

    @Value("${spring.cloud.consul.host}")
    private String consul;

    @PostConstruct
    public void init() {
        final ConsulClient client = new ConsulClient(consul);
        final String rootPath = "config/account";
        final ConsulWatchedConfigurationSource configSource =
                new ConsulWatchedConfigurationSource(rootPath, client);
        configSource.startAsync();
        ConcurrentCompositeConfiguration finalConfig = new ConcurrentCompositeConfiguration();
        finalConfig.addConfiguration(new DynamicWatchedConfiguration(configSource), "consul-dynamic");
        ConfigurationManager.install(finalConfig);

        final DynamicIntProperty delayProperty = DynamicPropertyFactory.getInstance().getIntProperty
                ("delay", 0);
        delayProperty.addCallback(new Runnable() {
            @Override
            public void run() {
                delay = delayProperty.get();
                logger.info("Changed " + delayProperty.get());
            }
        });
    }

    public List<Account> getAll() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(delay));
        } catch (InterruptedException e) {
            logger.error("Error: ", e);
        }

        return Arrays.asList(
                new Account("theo@mail.de", "Pack", "Theo"),
                new Account("hans@mail.de", "Müller", "Hans"));
    }
}
