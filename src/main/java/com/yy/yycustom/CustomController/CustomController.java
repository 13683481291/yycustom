package com.yy.yycustom.CustomController;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yy.yycustom.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class CustomController {

    @Autowired
    private RestTemplate rs; /* 发送请求方法，模板引擎*/

    @Autowired
    private DiscoveryClient discoveryClient; /* 去注册中心找到服务提供者*/

    @GetMapping("restHttp")
    public List<UserBean> restHttp() {

        List<ServiceInstance> instances = discoveryClient.getInstances("yp-server");
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://166.166.0.151" + ":" + serviceInstance.getPort() + "/helloSpringBoot";
        System.out.println(url);
        List<UserBean> list = rs.getForObject(url, List.class);
        System.out.println(list);
        return list;
    }

    @GetMapping("restUser")
    @HystrixCommand(fallbackMethod = "restUserFallBack")
    public List<UserBean> restUser() {

        String url = "http://yy-server/yy";
        List<UserBean> list = rs.getForObject(url, List.class);
        return list;
    }

    @GetMapping("restUserFallBack")
    public  List<UserBean> restUserFallBack(){

        List<UserBean> list  =new ArrayList<>();

        UserBean  user  = new UserBean();

        user.setUid("yy");
        user.setUname("11111查无此人");
        user.setUphone("号码为空11111");












        list.add(user);
        return list;
    }

}