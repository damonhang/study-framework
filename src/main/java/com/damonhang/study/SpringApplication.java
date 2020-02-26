package com.damonhang.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.RequestContextUtils;

@Configuration
public class SpringApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApplication.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
  }

  @Bean
  public MyService myService() {
    return new MyService();
  }

  private class MyService {

    public void doStuff() {
      System.out.println("doStuff");
    }
  }
}
