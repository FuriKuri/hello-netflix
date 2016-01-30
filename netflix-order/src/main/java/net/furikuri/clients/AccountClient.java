package net.furikuri.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class AccountClient {
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "findAllFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
    public List<Account> findAllAccounts() {
        return restTemplate.exchange("http://ACCOUNT/", HttpMethod.GET, null, new
                ParameterizedTypeReference<List<Account>>()
                {}).getBody();
    }

    private List<Account> findAllFallback() {
        return Collections.singletonList(new Account("guest", "guest", "guest"));
    }

//    @Autowired
//    private LoadBalancerClient loadBalancer;
//    public List<Account> findAllProducts() {
//        ServiceInstance instance = loadBalancer.choose("ACCOUNT");
//        String url = "http://" + instance.getHost() + ":" + instance.getPort();
//        return restTemplate.exchange(url, HttpMethod.GET, null, new
//                ParameterizedTypeReference<List<Account>>()
//                {}).getBody();
//    }
}
