package com.company.model;

import com.company.dto.LiveableConfig;
import com.company.model.enums.LiveableType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class NatureObject {

    BigDecimal weight;

    public NatureObject(LiveableConfig liveableConfig) {
        this(liveableConfig.getWeight());
    }

    public abstract LiveableType getLiveableType();

}
