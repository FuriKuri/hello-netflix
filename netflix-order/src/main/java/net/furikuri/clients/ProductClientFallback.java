package net.furikuri.clients;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public List<Product> findAllProducts() {
        return Collections.singletonList(new Product("Sticker", BigDecimal.valueOf(1.5)));
    }
}
