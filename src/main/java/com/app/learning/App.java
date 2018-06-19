package com.app.learning;

import com.app.learning.service.Helper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.IntStream;

public class App {
    private static final String[] workers = {"Matt", "Josch", "Maria", "Smith"};

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        IntStream.of(1, 2, 3, 4).forEach(counter -> {
            Helper helper = (Helper) applicationContext.getBean("helper", new Object[]{counter, workers[counter - 1]});
            helper.work();
        });
    }
}
