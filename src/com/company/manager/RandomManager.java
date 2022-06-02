package com.company.manager;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RandomManager {

    static RandomManager randomManager;
    ThreadLocalRandom random;

    public RandomManager(ThreadLocalRandom random) {
        this.random = random;
    }

    public static RandomManager getRandomManager() {
        if (randomManager == null) {
            synchronized (RandomManager.class) {
                randomManager = new RandomManager(ThreadLocalRandom.current());
            }
        }
        return randomManager;
    }

}
