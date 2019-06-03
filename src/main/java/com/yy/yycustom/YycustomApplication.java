package com.yy.yycustom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient  /*服务发现*/
@SpringBootApplication
@EnableHystrix /*熔断器*/
public class YycustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(YycustomApplication.class, args);
    }

    @Bean
    @LoadBalanced  /*负载均衡*/
     RestTemplate rs(){
        return  new RestTemplate();
    };
}
