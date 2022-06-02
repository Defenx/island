package com.company.service.randomservice;


import com.company.manager.RandomManager;
import com.company.model.enums.Direction;
import com.company.model.Cell;
import com.company.service.DirectionService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RandomDirectionService {

    DirectionService directionService = new DirectionService();
    RandomManager randomManager = RandomManager.getRandomManager();

    public Direction chooseRandomDirection(Cell cell, int speed) {
        List<Direction> directions = directionService.chooseCorrectDirection(cell, speed);
        ThreadLocalRandom random = randomManager.getRandom();
        int i = random.nextInt(0, directions.size());

        return directions.get(i);
    }

}
