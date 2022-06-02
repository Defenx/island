package com.company.service.coordinator;

import com.company.dto.AnimalsConfig;
import com.company.manager.ConfigManager;
import com.company.manager.RandomManager;
import com.company.model.Cell;
import com.company.model.Field;
import com.company.model.enums.LiveableType;
import com.company.service.FloraAndFaunaFactory;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.company.model.enums.LiveableType.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlantCoordinator {

    FloraAndFaunaFactory floraAndFaunaFactory = new FloraAndFaunaFactory();
    AnimalsConfig animalsConfig = ConfigManager.getConfigManager().getAnimalsConfig();
    RandomManager randomManager = RandomManager.getRandomManager();

    public void grow(Field field) {
        ThreadLocalRandom random = randomManager.getRandom();

        field.getCells()
                .stream()
                .flatMap(Collection::stream)
                .forEach(
                        cell -> {
                            int i = random.nextInt(0, 100);
                            IntStream.range(0, i)
                                    .forEach(j -> cell.getListOfEntity()
                                            .add(floraAndFaunaFactory
                                                    .getInstance(PLANT, animalsConfig.getConfig().get(PLANT))));
                        }
                );


    }

}
