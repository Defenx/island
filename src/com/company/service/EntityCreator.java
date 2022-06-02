package com.company.service;

import com.company.manager.ConfigManager;
import com.company.manager.RandomManager;
import com.company.dto.AnimalsConfig;
import com.company.model.NatureObject;
import com.company.model.enums.LiveableType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EntityCreator {

    AnimalsConfig animalConfig = ConfigManager.getConfigManager().getAnimalsConfig();
    FloraAndFaunaFactory factory = new FloraAndFaunaFactory();
    RandomManager randomManager = RandomManager.getRandomManager();

    public List<NatureObject> createEntities() {
        List<NatureObject> list = new ArrayList<>();
        LiveableType[] values = LiveableType.values();
        for (LiveableType value : values) {
            ThreadLocalRandom random = randomManager.getRandom();
            int randomCount = random.nextInt(0, animalConfig.getConfig().get(value).getCount());
            for (int j = 0; j < randomCount; j++) {
                list.add(factory.getInstance(value, animalConfig.getConfig().get(value)));
            }
        }
        Collections.shuffle(list);
        return list;
    }

}
