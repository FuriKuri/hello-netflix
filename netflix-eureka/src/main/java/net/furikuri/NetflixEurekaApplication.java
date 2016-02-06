package net.furikuri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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
        final String tutumContainerFqdn = System.getenv("TUTUM_SERVICE_FQDN");
        logger.info("Set Eureka configuration in Consul. FQDN: {}, HOST: {}, PORT: {}",
                tutumContainerFqdn, consulHost, consulPort);
        new RestTemplate(clientHttpRequestFactory()).put("http://" + consulHost + ":" + consulPort +
                "/v1/kv/config/application/eureka.client.serviceUrl.defaultZone",
                "http://" + tutumContainerFqdn + ":8761/eureka/");
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(2000);
        factory.setConnectTimeout(2000);
        return factory;
    }
}
