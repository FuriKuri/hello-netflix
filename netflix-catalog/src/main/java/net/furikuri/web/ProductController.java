package net.furikuri.web;

import net.furikuri.domain.Product;
import net.furikuri.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/")
    public List<Product> getAll() {
        return productService.getAll();
    }

}
