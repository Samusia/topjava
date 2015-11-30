package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Arrays;

/**
 * Created by Samusia
 * on 30.11.2015.
 */
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
        UserRepository userRepository = (UserRepository) appCtx.getBean("mockUserRepository");
        userRepository = appCtx.getBean(UserRepository.class);
        appCtx.close();
    }
}
