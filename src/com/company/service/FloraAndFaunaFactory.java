package com.company.service;

import com.company.dto.LiveableConfig;
import com.company.model.*;
import com.company.model.enums.LiveableType;
import com.company.model.impl.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.function.Function;

import static com.company.model.enums.LiveableType.*;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FloraAndFaunaFactory {

    Map<LiveableType, Function<LiveableConfig, NatureObject>> generatedMap =
            Map.ofEntries(
                    Map.entry(PLANT, Plant::new),
                    Map.entry(BEAR, Bear::new),
                    Map.entry(COW, Cow::new),
                    Map.entry(DEER, Deer::new),
                    Map.entry(EAGLE, Eagle::new),
                    Map.entry(FOX, Fox::new),
                    Map.entry(GOAT, Goat::new),
                    Map.entry(HAMSTER, Hamster::new),
                    Map.entry(HORSE, Horse::new),
                    Map.entry(KANGAROO, Kangaroo::new),
                    Map.entry(RABBIT, Rabbit::new),
                    Map.entry(SHEEP, Sheep::new),
                    Map.entry(SNAKE, Snake::new),
                    Map.entry(WOLF, Wolf::new),
                    Map.entry(DUCK, Duck::new),
                    Map.entry(CATERPILLAR, Caterpillar::new)
            );

    public NatureObject getInstance(LiveableType liveableType, LiveableConfig liveableConfig) {
        Function<LiveableConfig, NatureObject> function = generatedMap.get(liveableType);
        return function.apply(liveableConfig);
    }

}
