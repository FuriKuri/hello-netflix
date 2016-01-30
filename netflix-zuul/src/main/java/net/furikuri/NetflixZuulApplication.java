package net.furikuri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class NetflixZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApplication.class, args);
	}
}
