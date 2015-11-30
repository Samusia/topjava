package ru.javawebinar.topjava.web.user;

import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;

/**
 * Created by Samusia
 * on 30.11.2015.
 */
public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(LoggedUser.id());
    }

    public void delete() {
        super.delete(LoggedUser.id());
    }

    public void update(User user) {
        super.update(user, LoggedUser.id());
    }
}