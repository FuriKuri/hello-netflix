package net.furikuri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import java.io.IOException;

@SpringBootApplication
@EnableEurekaServer
public class NetflixEurekaApplication {
    private Logger logger = LoggerFactory.getLogger(NetflixEurekaApplication.class);

    @Value("${spring.cloud.consul.host}")
    private String consulHost;

    @Value("${spring.cloud.consul.port}")
    private String consulPort;

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaApplication.class, args);
	}

	@PostConstruct
	public void sendToConsul() throws IOException {
        final String tutumContainerFqdn = System.getenv("TUTUM_CONTAINER_FQDN");
        logger.info("Set Eureka configuration in Consul. FQDN: {}, HOST: {}, PORT: {}",
                tutumContainerFqdn, consulHost, consulPort);
        new RestTemplate().put("http://" + consulHost + ":" + consulPort +
                "/v1/kv/config/application/eureka.client.serviceUrl.defaultZone",
                "http://" + tutumContainerFqdn + ":8761/eureka/");
    }
}
