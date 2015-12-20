package ru.javawebinar.topjava.service;


import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.UserTo;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by Samusia
 * on 30.11.2015.
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    Collection<User> getAll();

    void update(UserTo user);

    void update(User user);

    void evictCache();

    void enable(int id, boolean enable);

    User getWithMeals(int id);
}
