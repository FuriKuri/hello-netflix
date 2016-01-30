package net.furikuri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NetflixCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixCatalogApplication.class, args);
	}
}
