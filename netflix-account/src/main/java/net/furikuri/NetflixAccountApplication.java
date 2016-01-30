package net.furikuri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NetflixAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixAccountApplication.class, args);
	}
}
