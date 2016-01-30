package net.furikuri.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "catalog", fallback = ProductClientFallback.class)
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<Product> findAllProducts();
}


