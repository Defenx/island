package com.company.model;

import com.company.dto.LiveableConfig;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Fauna extends NatureObject {
    Integer speed;
    BigDecimal satiety;
    Integer stepForDieWithoutFood;

    public Fauna(LiveableConfig liveableConfig) {
        super(liveableConfig);
        this.speed = liveableConfig.getSpeed();
        this.satiety = liveableConfig.getSatiety();
        this.stepForDieWithoutFood = liveableConfig.getStepForDieWithoutFood();
    }

}
