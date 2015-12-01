package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.TimeUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

/**
 * Created by Samusia
 * on 29.11.2015.
 */
@Repository
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {

    public static final Comparator<UserMeal> USER_MEAL_COMPARATOR = (um1, um2) -> um2.getDateTime().compareTo(um1.getDateTime());

    // Map  userId -> (mealId-> meal)
    private Map<Integer, Map<Integer, UserMeal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500), USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000), USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500), USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000), USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500), USER_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510), USER_ID);

        save(new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "Админ ланч", 510), ADMIN_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1, 21, 0), "Админ ужин ", 510), ADMIN_ID);
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        Integer mealId = userMeal.getId();

        if (userMeal.isNew()) {
            mealId = counter.incrementAndGet();
            userMeal.setId(mealId);
        } else if (get(mealId, userId) == null) {
            return null;
        }
        Map<Integer, UserMeal> userMeals = repository.computeIfAbsent(userId, ConcurrentHashMap::new);
        userMeals.put(mealId, userMeal);
        return userMeal;

    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer, UserMeal> userMeals = repository.get(userId);
        return userMeals != null && userMeals.remove(id) != null;
    }

    @Override
    public UserMeal get(int id, int userId) {
        Map<Integer, UserMeal> userMeals = repository.get(userId);
        return userMeals == null ? null : userMeals.get(id);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return repository.get(userId).values().stream().sorted(USER_MEAL_COMPARATOR).collect(Collectors.toList());
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return getAll(userId).stream()
                .filter(um -> TimeUtil.isBetween(um.getDateTime(), startDateTime, endDateTime))
                .sorted(USER_MEAL_COMPARATOR)
                .collect(Collectors.toList());
    }
}