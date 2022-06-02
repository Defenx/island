package com.company.service.randomservice;

import com.company.manager.RandomManager;
import com.company.model.Fauna;
import com.company.model.NatureObject;
import com.company.model.Cell;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RandomFoodService {

    RandomManager randomManager = RandomManager.getRandomManager();

    public NatureObject chooseRandomNatureObjectForEat(Cell cell, Fauna fauna) {
        List<NatureObject> collect = cell.getListOfEntity()
                .stream()
                .filter(e -> !e.getLiveableType().equals(fauna.getLiveableType()))
                .toList();
        ThreadLocalRandom random = randomManager.getRandom();
        int randomIndex = random.nextInt(0, collect.size());

        return collect.get(randomIndex);
    }

}
