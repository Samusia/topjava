package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.BaseEntity;

/**
 * Created by Samusia
 * on 30.11.2015.
 */
public class LoggedUser {
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static int getCaloriesPerDay() {
        return 2000;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }
}
