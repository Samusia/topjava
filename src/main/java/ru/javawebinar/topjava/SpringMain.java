package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserService;

import java.util.Arrays;

/**
 * Created by Samusia
 * on 30.11.2015.
 */
public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
        UserService userService = appCtx.getBean(UserService.class);
        System.out.println(userService.save(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));
        appCtx.close();
    }
}
