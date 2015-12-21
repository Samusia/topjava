package ru.javawebinar.topjava.util;

import org.springframework.util.StringUtils;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.UserTo;

/**
 * Created by Samusia
 * on 19.12.2015.
 */
public class UserUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static User createFromTo(UserTo newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getPassword(), Role.ROLE_USER);
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getCaloriesPerDay());
    }

    public static User updateFromTo(User user, UserTo userTo) {
        String password = userTo.getPassword();
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        return user;
    }
}
