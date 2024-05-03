package main.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServerApplication {
    public static void main(String[] args) {
        System.out.println("Hello EurekaServer~~~~~!");
    }
}