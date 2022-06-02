package com.company.service;

import com.company.manager.ConfigManager;
import com.company.manager.RandomManager;
import com.company.dto.EatingChanceConfig;
import com.company.model.Fauna;
import com.company.model.NatureObject;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FoodService {

    EatingChanceConfig eatingChanceConfig = ConfigManager.getConfigManager().getEatingChanceConfig();
    RandomManager randomManager = RandomManager.getRandomManager();

    public Optional<NatureObject> eat(Fauna who, NatureObject whom) {
        Integer animalEatingChance = eatingChanceConfig.getConfig().get(who.getLiveableType()).get(whom.getLiveableType());

        ThreadLocalRandom random = randomManager.getRandom();
        int generatedChance = random.nextInt(0, 100);
        return Optional.of(who)
                .filter(fauna -> generatedChance > animalEatingChance)
                .map(obj -> {
                    obj.setSatiety(whom.getWeight());
                    return whom;
                });
    }

}
